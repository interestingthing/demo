package com.client.feign.config;

import feign.Logger;
import feign.Request;
import feign.Response;
import feign.Util;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringEscapeUtils;
import java.io.IOException;
import java.util.Enumeration;

import static feign.Util.UTF_8;
import static feign.Util.decodeOrDefault;

/**
 * @author:jenny
 * @Date:2018/12/29
 * @Description
 */
@Slf4j
public class FeignLogger extends Logger {
    @Override
    protected void log(String configKey, String format, Object... args) {
        log.info(String.format(methodTag(configKey) + format, args));
    }

    @Override
    protected void logRequest(String configKey, Level logLevel, Request request) {
        if (logLevel.ordinal() != Level.BASIC.ordinal()) {
            super.logRequest(configKey, logLevel, request);
            return;
        }

        log.info("request is {}",request.toString());

        if (request.body() != null) {
                String bodyText = request.charset() != null ? new String(request.body(), request.charset()) : null;
                log(configKey, "---> %s %s %s", request.method(), request.url(), bodyText != null ? bodyText : "Binary data");
                return;
        }
        log(configKey, "---> %s %s", request.method(), request.url());
    }

    @Override
    public Response logAndRebufferResponse(String configKey, Level logLevel, Response response,
                                           long elapsedTime) throws IOException {
        if (logLevel.ordinal() != Level.BASIC.ordinal()) {
            return super.logAndRebufferResponse(configKey, logLevel, response, elapsedTime);
        }
        String reason = response.reason() != null && logLevel.compareTo(Level.NONE) > 0 ?
                " " + response.reason() : "";
        int status = response.status();
        int bodyLength = 0;
        if (response.body() != null && !(status == 204 || status == 205)) {
            byte[] bodyData = Util.toByteArray(response.body().asInputStream());
            bodyLength = bodyData.length;
            if (bodyLength > 0) {
                log(configKey, "<--- %s %s(status=%s,take_time=%sms,message=%s)%s",
                        response.request().method(), response.request().url(), status, elapsedTime, reason,
                        StringEscapeUtils.unescapeJava(decodeOrDefault(bodyData, UTF_8, "Binary data")));
            }
            return response.toBuilder().body(bodyData).build();
        } else {
            log(configKey, "<--- END HTTP (%s-byte body)", bodyLength);
        }

        return response;
    }

}
