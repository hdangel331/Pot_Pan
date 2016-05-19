package com.example.ziyang.potpan.Data;

public final class zzy_constants {

    public static final String SOCKET_ERROR = "0";
    public static final String SOCKET_IOERROR = "1";
    public final static String IP = "10.8.50.75";//获取当前ip
    public final static int POINT = 9999;//定义piont为9999

    public static final String ADD_USERINFO = "ADD_USERINFO";
    public static final String GET_PASSWORDBYACCOUNT = "GET_PASSWORDBYACCOUNT";//根据ID查询员工姓名
    public static final String GET_EMAILBYACCOUNT = "GET_EMAILBYACCOUNT";
    public static final String UPDATE_PASSWORD = "UPDATE_PASSWORD";
    public static final String GET_RECIPEBYACCOUNT = "GET_RECIPEBYACCOUNT";
    public static final String GET_CONTENTBYNAME = "GET_CONTENTBYNAME";
    public static final String GET_LIB = "GET_LIB";
    public static final String ADD_RECIPEFROMLIB = "ADD_RECIPEFROMLIB";
    public static final String DELETE_RECIPE = "DELETE_RECIPE";
    public static final String UPDATE_RECIPE = "UPDATE_RECIPE";
    public static final String ADD_MATERIAL = "ADD_MATERIAL";
    public static final String ADD_SEASONING = "ADD_SEASONING";

//    public static final String[] MATERIAL = new String[]{
//            //无底
//            "http://img0.ph.126.net/XZj-ve3cqtprM2n6HWZM4g==/6598205562230017023.png",    //虾shrimp
//            "http://img0.ph.126.net/lf7pX0Bi7_XRoVtn2eLXDg==/6598096710578866647.png",    //生菜lettuce
//            "http://img0.ph.126.net/vTM_cRcUPVnBFfu6an-rWw==/4822229301107659275.png",    //玉米corn
//            "http://img2.ph.126.net/mrEqo4f2Nz7Fj8s7NVlj3Q==/4927500942397884983.jpg",    //蛋egg
//            "http://img0.ph.126.net/pBzUwV8Mronz_H7BLSOL-g==/6598194567113736612.png",    //南瓜pumpkin
//            "http://img0.ph.126.net/294XcV9ju_K1Xi4pvdCZrQ==/6598248443183493594.png",    //韭菜leek
//            "http://img2.ph.126.net/YeWYZl7bBhcxvLOBFjTWDQ==/4877961346496376488.png",    //芹菜celery
//            "http://img0.ph.126.net/UxXsT2pObhs8ZL23HZh0uQ==/6598237448067212850.png",    //土豆potato
//            "http://img1.ph.126.net/Z7Cmz9rLsSDRWudILNoJAg==/1629458640279908017.png",    //鱼fish
//            "http://img1.ph.126.net/Spu_8hgPLzdZly-81Y-Osg==/6598218756369549970.png",    //牛肉beef
//            "http://img0.ph.126.net/SLJjl8Qq_1rmsw1dtkC4zA==/200691658496802459.png",    //蘑菇mushroom
//            "http://img1.ph.126.net/6hpBsUje1GhXKSenfMeyeg==/1624673565676011151.png",    //茄子eggplant
//            "http://img0.ph.126.net/Ns8UKPzDPG2sdvdQevAYHQ==/6598205562230017017.png",    //鸡chenken
//            "http://img1.ph.126.net/MBNuw9PSBHFkjZrXxOuWUw==/6598150586648629360.png",    //培根bacon
//            "http://img0.ph.126.net/a7RSwsj7zslUJ2RDScBuwQ==/4819414551340552719.png",    //番茄tomato
//            "http://img2.ph.126.net/dAlUd8kjyhZ00AaqNYokKw==/6598286926090477628.png",    //鸡腿drumstick
//            "http://img2.ph.126.net/lNMi2XA-6dZNteuCwPDbtg==/2002694459398572716.png"    //胡萝卜carrot
//    };

    public static final String[] MATERIAL = new String[]{
            "http://img1.ph.126.net/dbhLzGWfb_aDGfnQIx-3eg==/4830392075432277124.png",    //虾shrimp
            "http://img2.ph.126.net/UjohW6qlQ5Z20T_kvQzghg==/6598238547578841257.png",    //生菜lettuce
            "http://img1.ph.126.net/XVpPddNT8nlJxC5U9ceY_w==/6598186870532343652.png",    //玉米corn
            "http://img3.douban.com/view/note/large/public/p9618462.jpg",    //蛋egg
            "http://img2.ph.126.net/HBG4HfiRhjhRW_nZiCYydw==/4914271618492052636.png",    //南瓜pumpkin
            "http://img1.ph.126.net/Mkv-a6LDkZBXfUUvtFlYKQ==/4851784173662903215.png",    //韭菜leek
            "http://img1.ph.126.net/TVBYtN2EDyr6uFTnVeMWHQ==/4858539573103958926.png",    //芹菜celery
            "http://img0.ph.126.net/WvlrQ1J_eItQSThMnYWAVA==/4856287773290389788.png",    //土豆potato
            "http://img1.ph.126.net/Mm2RqOLQLwAlIL2O7AC4bQ==/4901886719516774539.png",    //鱼fish
            "http://img1.ph.126.net/wtltLf2pSy1XUrTIQAOukw==/4856287773290389783.png",    //牛肉beef
            "http://img1.ph.126.net/eMJXKV36052InWDezX2XWQ==/1158269529265787755.png",    //蘑菇mushroom
            "http://img0.ph.126.net/D412YoDAxiaqKwcLlsQdkQ==/6598238547578841255.png",    //茄子eggplant
            "http://img1.ph.126.net/E0qWK-tPSqOaBPXAZpnPaA==/6598201164183503791.png",    //鸡chenken
            "http://img0.ph.126.net/wSY8Z7t4HWLKhH7oMhlO8Q==/6598222054904433930.png",    //培根bacon
            "http://img2.ph.126.net/Q4hk9iYKStBiuMjNQroW5A==/6598111004230033553.png",    //番茄tomato
            "http://img1.ph.126.net/5RxBOB9ijazP6BK0pnNhpQ==/4841932549478142844.png",    //鸡腿drumstick
            "http://img2.ph.126.net/36uIyW2qR7Iow9_2j9ljFg==/6598098909602122856.png",    //胡萝卜carrot
            "http://img0.ph.126.net/Z1vs6nAH_4xM0er5KljpDg==/1999879709631131925.png",    //米饭rice
            "http://img0.ph.126.net/UyEm5LlnW8pSe1sfo5f1aQ==/6598220955392806152.png"     //苦瓜balsamPear
    };

    public static final String[] MATERIALNAME = new String[]{
            "shrimp",
            "lettuce",
            "corn",
            "egg",
            "pumpkin",
            "leek",
            "celery",
            "potato",
            "fish",
            "beef",
            "mushroom",
            "eggplant",
            "checken",
            "bacon",
            "tomato",
            "drumstick",
            "carrot",
            "rice",
            "balsamPear"
    };

    public static final String[] SEASONING = new String[]{
            "http://img1.ph.126.net/4vN8qpXTPyNLWKWYaGbrPA==/6598131894950950951.png",
            "http://img1.ph.126.net/RkdJKaGlWQkyarbOG2KYmg==/4872894796915578349.png",
            "http://img2.ph.126.net/DTsXCq1zn6u1vaFKVpExQw==/6598189069555598801.png",
            "http://img1.ph.126.net/TYPTSzouqxc-pRQp5GrcEA==/4827295850688458455.png",
            "http://img1.ph.126.net/GKmJWi6CXsaO2N_ueu7-tw==/4859946947987624596.png",
            "http://img2.ph.126.net/Sq7tJ5XU6fc6aGGgBEBz5w==/6598174775904439679.png",
            "http://img2.ph.126.net/ksiDuSM-iD3PHbpq0mjD-w==/1995376110003945296.png",
            "http://img0.ph.126.net/wazpZU2mKVkstMaPRu9Y7A==/6598124198369560050.png",
            "http://img2.ph.126.net/kvK4AuIjiBiPiFu8QBcOQg==/4827295850688458453.png",
            "http://img0.ph.126.net/EJ2edlhcYXFc10CrTg-Ghw==/1995376110003945300.png",
            "http://img2.ph.126.net/geM8AsWYIweZNGGsNPDXXQ==/4930597167141666053.png",
            "http://img2.ph.126.net/jLpz71jSdzXPlu-9RsiRbA==/6598297921206762791.png",
            "http://img2.ph.126.net/M7RbS_EsfhFWnAwCFrJKVQ==/1628895690326415323.png"
    };

    public static final String[] SEASONINGNAME = new String[]{
            "soy sauce",
            "salt",
            "tsaoko",
            "shallot",
            "curry",
            "onion",
            "cinnamon",
            "rosemary",
            "cumin",
            "sugar",
            "ginger",
            "chilli",
            "garlic"
    };

    private zzy_constants() {

    }
}
