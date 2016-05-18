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

    public static final String[] START = new String[]{
            "http://www.scnjnews.com/ms/image/attachement/jpg/site2/20091228/00241dd8ce9b0ca29ea93b.jpg",
            "http://www.scnjnews.com/ms/image/attachement/jpg/site2/20091228/00241dd8ce9b0ca29ea93b.jpg"
    };


    public static final String[] library = new String[]{
            "http://pic3.nipic.com/20090623/2743956_192919027_2.jpg",
            "http://file2.zhituad.com/thumb/201201/13/201201130300339473kNpfJ_priv.jpg",
            "http://img4.duitang.com/uploads/blog/201403/18/20140318120254_LXV4P.thumb.600_0.jpeg",
            "http://pic4.nipic.com/20091022/3548141_102749135821_2.jpg",
            "http://pic33.nipic.com/20130923/10015044_035315378105_2.jpg",
            "http://img1.imgtn.bdimg.com/it/u=1146456311,2828071472&fm=21&gp=0.jpg",
            "http://e.hiphotos.baidu.com/bainuo/crop%3D0%2C0%2C690%2C459%3Bw%3D690%3Bq%3D90%3Bc%3Dnuomi%2C95%2C95/sign=e343044bd32a6059465fbb5a150418ab/ae51f3deb48f8c5426a22dad3e292df5e0fe7f3b.jpg",
            "http://img1.imgtn.bdimg.com/it/u=2231617500,3408850511&fm=21&gp=0.jpg",
    };

    public static final String[] RECIPE = new String[]{
            "http://img.taopic.com/uploads/allimg/140720/240467-140H00K62786.jpg",
            "http://image.tianjimedia.com/uploadImages/2012/345/44R6RY4Q0219_1680x1050.jpg",
            "http://image.tianjimedia.com/uploadImages/2013/134/001GKNRJ7FCO_1440x900.jpg",
            "http://image.tianjimedia.com/uploadImages/2011/360/89241H21087M.jpg",
            "http://tupian.enterdesk.com/2014/lxy/2014/05/07/2/8.jpg",
            "http://s9.knowsky.com/bizhi/l/1-5000/200952814217740135370.jpg",
            "http://image.tianjimedia.com/uploadImages/2013/304/Y83292KWIFAT_1920x1200.jpg",
            "http://tupian.enterdesk.com/2013/xll/003/0312/aodaliya/1.jpg",
            "http://img.tuku.cn/file_big/201504/024448d7ae994d4d9273ea5f3c199a5a.jpg",
            "http://p2.image.hiapk.com/uploads/allimg/130702/23-130F2135J5.jpg"
    };

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


    public static class Config {
//        public static final boolean DEVELOPER_MODE = false;
    }

    public static class Extra {
//        public static final String FRAGMENT_INDEX = "com.nostra13.example.universalimageloader.FRAGMENT_INDEX";
//        public static final String IMAGE_POSITION = "com.nostra13.example.universalimageloader.IMAGE_POSITION";
    }
}
