package com.client.domain;

import com.google.common.collect.ImmutableMap;


/**
 * 常量
 * @author
 * @date
 */
public class Constants {

    private Constants(){}

    /**
     * 请求参数String类型转换成list的最大容量
     */
    public static final Integer MAX_COUNT_PER_REQUEST = 100;

    /**
     * 之前所有选5～10区间的，映射到 8～10
     */
    public static final ImmutableMap<Integer, Integer> PRICE_MAP = ImmutableMap.<Integer, Integer>builder()
            .put(1, 11)
            .build();

    /**
     * 目标车价枚举值：请选择、5～10万、10～15万、15～20万、20～25万、25～30万、30～35万、35～40万、40～50万、50～60万
     */
    public static final ImmutableMap<Integer, Integer[]> TARGET_CAR_PRICE_RANGE = ImmutableMap.<Integer, Integer[]>builder()
            .put(1, new Integer[]{5000000, 10000000})
            .put(2, new Integer[]{10000000, 15000000})
            .put(3, new Integer[]{15000000, 20000000})
            .put(4, new Integer[]{20000000, 25000000})
            .put(5, new Integer[]{25000000, 30000000})
            .put(6, new Integer[]{30000000, 35000000})
            .put(7, new Integer[]{35000000, 40000000})
            .put(8, new Integer[]{40000000, 50000000})
            .put(9, new Integer[]{50000000, 60000000})
            .put(10, new Integer[]{5000000, 8000000})
            .put(11, new Integer[]{8000000, 10000000})
            .build();

    public static final ImmutableMap<Integer, String> TARGET_CAR_PRICE = ImmutableMap.<Integer, String>builder()
            //提供给太阳花时，要去掉
            .put(1, "5～10")
            .put(10, "5～8")
            .put(11, "8～10")
            .put(2, "10～15")
            .put(3, "15～20")
            .put(4, "20～25")
            .put(5, "25～30")
            .put(6, "30～35")
            .put(7, "35～40")
            .put(8, "40～50")
            .put(9, "50～60")
            .build();

    public static final Integer GRAY_OLD_VERSION = 1;
    public static final Integer GRAY_NEW_VERSION = 2;
    public static final Integer GRAY_DIFF_PRICE_VERSION = 3;

	public static final String INFO_FLOW_2_2="2:2";
    public static final String PAY_FLOW_3_1="3:1";
    public static final String PAY_FLOW_3_2="3:2";
    public static final String DELIVERY_5_5 = "5:5";
    public static final Integer COUPON_FORZEN=1;
    public static final Integer COUPON_CLOSURE=2;
    public static final String ACTION_GROUP="35,36,37,38,39,40,41,42,43,50";

    /**
     * 优惠券接口返回数组 key=4 --可使用优惠券
     */
    public static final Integer COUPON_ALREADY_USE_INDEX = 1;
    /**
     * 优惠券接口返回数组 key=4 --可使用优惠券
     */
    public static final Integer COUPON_CAN_USE_INDEX = 4;
    /**
     * 优惠券接口返回key=optimum
     */
    public static final String OPTIMUM_NAME = "optimum";

    /**
     * 代表C端
     */
    public static final Integer COUPON_CLIENT_TYPE_1 = 1;

    /**
     * 代表太阳花
     */
    public static final Integer COUPON_CLIENT_TYPE_0 = 0;

    /**
     * 代表补券
     */
    public static final Integer COUPON_BUQUAN_STATUS_1 = 1;
    public static final Integer COUPON_BUQUAN_STATUS_0 = 0;//代表不补券

    public static final Integer COUPON_HUANCHE_STATUS_1 = 1;//代表换车

    public static final Integer COUPON_HUANCHE_STATUS_0 = 0;//代表不换车


    /**
     * 三天的秒
     */
    public static final Integer THREE_DAY_SECOND = 259200;

    /**
     * IPV6
     */
    public static final String IP_LOCALHOST_V6 = "0:0:0:0:0:0:0:1";
    /**
     * localhost IP
     */
    public static final String IP_LOCALHOST = "127.0.0.1";

}