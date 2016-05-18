package com.example.ziyang.potpan;


/**
 * Created by Ziyang on 2016/4/24.
 */
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
            "http://i2.buimg.com/ccebf2760ee5ec39.png",    //egg
            "http://i2.buimg.com/a1a733d24c87d951.png",    //tomato
            "http://i2.buimg.com/02aececc3194a73d.png",  //carrot
            "http://i2.buimg.com/e204c8b19e7425ad.png", //bacon
            "http://i2.buimg.com/a4d6736c45a7ef10.png",  //balsam pear
            "http://i2.buimg.com/7926487278c89b89.png", //beef
            "http://i2.buimg.com/bf3cd546397eac7a.png",    //shrimp
            "http://i2.buimg.com/996581671bc2a3af.png",    //mushroom
            "http://i2.buimg.com/38afb5bb4f4265be.png", //celery
            "http://i2.buimg.com/863c38cefc4ce419.png",    //rice
            "http://i2.buimg.com/486efe144e0a1ca4.png",    //leek
            "http://i2.buimg.com/41c062e65c5b7efe.png",    //corn
            "http://i2.buimg.com/78184b019bc95682.png",    //eggplant
            "http://i2.buimg.com/0475f76a8d6f7efb.png",    //checken
            "http://i2.buimg.com/ffd65418b332237f.png",    //potapo
            "http://i2.buimg.com/c36261535dcec739.png",    //fish
            "http://i2.buimg.com/7e65df655ab6cdce.png",    //chinesecabbage
            "http://i2.buimg.com/6eaa4c1c32b6181b.png",    //pumpkin
            "http://i2.buimg.com/148fa146e92780ea.png",    //lettuce
            "http://i2.buimg.com/25bf462a154c20cd.png"    //drumstick
    };

    public static final String[] MATERIALNAME = new String[]{
            "egg",
            "tomato",
            "carrot",
            "bacon",
            "balsam pear",
            "beef",
            "shrimp",
            "mushroom",
            "celery",
            "rice",
            "leek",
            "corn",
            "eggplant",
            "checken",
            "potapo",
            "fish",
            "chinesecabbage",
            "pumpkin",
            "lettuce",
            "drumstick"
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
