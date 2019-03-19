package com.client.feign.config;

import feign.RequestTemplate;
import feign.codec.EncodeException;
import feign.codec.Encoder;
import feign.form.FormEncoder;

import java.lang.reflect.Type;

/**
 * @Author: chenjingang@gauzi.com  2019/3/14 21:54
 */
public class FeignEncoder extends FormEncoder {
    public FeignEncoder() {
        super();
    }

    public FeignEncoder(Encoder delegate) {
        super(delegate);
    }

    @Override
    public void encode(Object object, Type bodyType, RequestTemplate template) throws EncodeException {
        String method = template.method();
        super.encode(object, bodyType, template);
//        if ("GET".compareToIgnoreCase(method) == 0 && template.requestBody().asString().length() != 0) {
//            String body = template.requestBody().asString();
//
//            if (body.contains("{") && body.contains("}") && body.contains(":")) {
//                body=jsonToUrl(body);
//            }
//
//            template.uri("?" + body, true);
//            template.header("Content-type",MediaType.APPLICATION_FORM_URLENCODED_VALUE);
//        }
    }

    private String jsonToUrl(String s) {
        return s.replaceAll("[\\{\\}\\s+\"\\s]", "")
                .replaceAll("[:]", "=")
                .replaceAll("[,]", "&");
    }
}
