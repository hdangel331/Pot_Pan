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

    public static final String[] MATERIAL = new String[]{
            "http://i2.buimg.com/9a2dc98717401a96.png",    //虾shrimp
            "http://i2.buimg.com/b86da1ffbe8739c0.png",    //生菜lettuce
            "http://i2.buimg.com/217e8e9548ecc629.png	",    //玉米corn
            "http://i2.buimg.com/c47e649d5955bb35.jpg",    //蛋egg
            "http://i2.buimg.com/79f7762c317bc527.png",    //南瓜pumpkin
            "http://i2.buimg.com/54beb337af2e4dbc.png",    //韭菜leek
            "http://i2.buimg.com/320eb7c892960763.png",    //白菜chinese cabbage
            "http://i2.buimg.com/3498a0e1fdf01867.png",    //芹菜celery
            "http://i2.buimg.com/f1a2e9b97c551d2d.png",    //土豆potato
            "http://i2.buimg.com/838a983b37b77cc2.png",    //鱼fish
            "http://i3.buimg.com/b0ef9a2297b8ea7c.png",    //牛肉beef
            "http://i2.buimg.com/017bb64f173cf34f.png",    //蘑菇mushroom
            "http://i2.buimg.com/d45e2f71e117ee48.png",    //茄子eggplant
            "http://i2.buimg.com/a8f8ccb48b421746.png",    //鸡chenken
            "http://i2.buimg.com/bf4289726a16dddd.png",    //培根bacon
            "http://i2.buimg.com/e02a3c309d93d349.png",    //番茄tomato
            "http://i2.buimg.com/80bf7f97e6412495.png",    //鸡腿drumstick
            "http://i2.buimg.com/44474c336dff7422.png"    //胡萝卜carrot
    };

    public static final String[] MATERIALNAME = new String[]{
            "shrimp",
            "lettuce",
            "corn",
            "egg",
            "pumpkin",
            "leek",
            "chinese cabbage",
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
            "carrot"
    };

    public static final String[] SEASONING = new String[]{
            "http://i3.buimg.com/00bccaaf111cc5aa.png",    //soy sauce
            "http://i3.buimg.com/a6ac892607a7c056.png",    //salt
            "http://i3.buimg.com/84b0a0d880bff449.png",    //tsaoko
            "http://i3.buimg.com/7726163354fd00b2.png",    //shallot
            "http://i3.buimg.com/e0f9f0db383ccb74.png",    //curry
            "http://i3.buimg.com/6f11d8c08fd260a2.png",    //star anise
            "http://i3.buimg.com/68cd60630f6b9ef6.png",    //onion
            "http://i3.buimg.com/ca629336b2827dea.png",    //cinnamon
            "http://i3.buimg.com/72c576b76d0ddb58.png",    //rosemary
            "http://i3.buimg.com/f88e315322ef8f77.png",    //cumin
            "http://i3.buimg.com/60ea03d4b4c5d0d8.png",    //sugar
            "http://i3.buimg.com/fe9ba31decb30472.png",    //ginger
            "http://i3.buimg.com/387ed18ed50ed1ab.png",    //chilli
            "http://i3.buimg.com/88067903db5341b3.png"    //garlic
    };

    public static final String[] SEASONINGNAME = new String[]{
            "soy sauce",
            "salt",
            "tsaoko",
            "shallot",
            "curry",
            "star anise",
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
