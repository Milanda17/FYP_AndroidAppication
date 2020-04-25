package org.tensorflow.lite.examples.classification.indoormap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class FloorPlan {

    public List<String> getFloorPlan() {

        // 01-04 is represent row-col
        List<String> list = Arrays.asList("00-00","00-01","00-02","00-03","00-04","00-05","00-06","00-07","00-08","00-09","00-10",
                "00-11","00-12","00-13","00-14","00-15","00-16","00-17","00-18","00-19","00-20",
                "00-21","00-22","00-23","00-24","00-25","00-26","00-27","00-28","00-29","00-30",
                "00-31","00-32","00-33","00-34","00-35","00-36","00-37","00-38","00-39","00-40",
                "00-41","00-42","00-43","00-44","00-45","00-46","00-47","00-48","00-49",


                "19-00","19-01","19-02","19-03","19-04","19-05","19-06","19-07","19-08","19-09","19-10",
                "19-11","19-12","19-13","19-14","19-15","19-16","19-17","19-18","19-19","19-20",
                "19-21","19-22","19-23","19-24","19-25","19-26","19-27","19-28","19-29","19-30",
                "19-31","19-32","19-33","19-34","19-35","19-36","19-37","19-38","19-39","19-40",
                "19-41","19-42","19-43","19-44","19-45","19-46","19-47","19-48","19-49",


                "01-00","02-00","03-00","04-00","05-00","06-00","07-00","08-00","09-00","10-00",
                "11-00","12-00","13-00","14-00","15-00","16-00","17-00","18-00","19-00",

                "01-49","02-49","03-49","04-49","05-49","06-49","07-49","08-49","09-49","10-49",
                "11-49","12-49","13-49","14-49","15-49","16-49","17-49","18-49","19-49"
                );

        return list;
    }


    public List<String> getCart() {

        // 01-04 is represent row-col
        List<String> list = Arrays.asList("02-01","02-02");

        return list;
    }

    public List<String> getCashier() {

        // 01-04 is represent row-col
        List<String> list = Arrays.asList("02-13","02-14","02-15","02-16","02-21","02-22","02-23","02-24","02-29","02-30","02-31","02-32","02-37","02-38","02-39","02-40");

        return list;
    }


    public List<String> getRackPlan() {

        List<String> rackPlan = new ArrayList<>();
        LinkedHashMap<String, String> rackHashMap = new LinkedHashMap<String, String>();
        rackHashMap = getRackWithItem();

        for (int a = 0; a < rackHashMap.size(); a++) {
            String value = (new ArrayList<String>(rackHashMap.values())).get(a);

            if (!(rackPlan.contains(value))) {
                rackPlan.add(value);
            }

        }

        return rackPlan;
    }

    public List<String> getItemList() {

        List<String> itemList = new ArrayList<>();
        LinkedHashMap<String, String> rackHashMap = new LinkedHashMap<String, String>();
        rackHashMap = getRackWithItem();

        for (int a = 0; a < rackHashMap.size(); a++) {
            String value = (new ArrayList<String>(rackHashMap.keySet())).get(a);

            if (!(itemList.contains(value))) {
                itemList.add(value);
            }

        }

        return itemList;
    }

    public String getRackIdUsingItem(String item) {

        LinkedHashMap<String, String> rackIdHashMap = new LinkedHashMap<String, String>();
        rackIdHashMap = getRackWithItem();
        rackIdHashMap.get(item);

        return rackIdHashMap.get(item);
    }


    public LinkedHashMap<String, String> getRackWithItem() {

        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();

        linkedHashMap.put("AMBEWELA FRESH MILK  1L","09-01");
        linkedHashMap.put("DILMAH GREEN TEA","08-15");
        linkedHashMap.put("FORTUNE VEGETABLE OIL 1L","14-15");
        linkedHashMap.put("KEELLS BROWN SUGAR 1KG","14-06");
        linkedHashMap.put("MD MIXED FRUIT CHUTNEY 450G","15-31");
        linkedHashMap.put("KEELLS OVEN CASHEW 200G","06-14");
        linkedHashMap.put("PRIMA FLOUR 1KG","13-31");


        linkedHashMap.put("ASTRA BUTTER 100G","04-01");
        linkedHashMap.put("ASTRA GOOD STAR 18G","04-01");
        linkedHashMap.put("ASTRA GOOD STAR 250G","04-01");
        linkedHashMap.put("ASTRA TIKIRI","04-01");

        linkedHashMap.put("ELEHANT HOUSE EGB 1L","05-01");///

        linkedHashMap.put("ELEPHANT 2 BAR VANILA-FALUDA 60 ML","06-01");

        linkedHashMap.put("ELEPHANT HOUSE VANILLA 500ML","07-01");///

        linkedHashMap.put("ELEPHANT HOUSE WATERMELON","08-01");
        linkedHashMap.put("ELEPHANT ICE CUP CHOCOLATE 80 ML","08-01");
        linkedHashMap.put("ELEPHANT ICE CUP PANI-CADJU 80ML","08-01");

        linkedHashMap.put("ELEPHANT ICE CUP VANILLA 80ML","09-01");

        linkedHashMap.put("ELEPHANT ICE VANILLA 1L","10-01");///

        linkedHashMap.put("FANTA 2L","11-01");///

        linkedHashMap.put("FANTA PORTELLO 1.5L","12-01");///

        linkedHashMap.put("HAPPY COW CHEESE 120G","13-01");

        linkedHashMap.put("HIGHLAND FRESH MILK 1L","14-01");///
        linkedHashMap.put("HIGHLAND FRESH MILK 450 ML","14-01");///

        linkedHashMap.put("CHICKEN SAUSAGES 250G","15-01");///

        linkedHashMap.put("BAIRAHA CHICKEN 1KG","16-01");///


        linkedHashMap.put("KEELLS CHICKEN MEAT BALL 100G","17-01");///
        linkedHashMap.put("KEELLS CHICKEN MEAT BALL 200G","17-01");///

        linkedHashMap.put("HAPPY HEN 10 EGGS PACK","18-01");///
        linkedHashMap.put("EGGS WHITE 1 PCS","18-01");///
        linkedHashMap.put("EGG WHITE SMALL 1PCS","18-01");///
        linkedHashMap.put("EGGS BROWN 1 PCS","18-01");///

        linkedHashMap.put("ARALIYA KEERI SAMBA 5KG","07-06");
        linkedHashMap.put("ARALIYA NADU 10KG","07-06");
        linkedHashMap.put("ARALIYA NADU 5KG","07-06");

        linkedHashMap.put("ARALIYA RED RAW 5KG","07-07");
        linkedHashMap.put("ARALIYA SAMBA 5KG","07-07");
        linkedHashMap.put("ARALIYA SAMBA 10KG","07-07");

        linkedHashMap.put("ARALIYA WHITE RAW 10KG","08-06");
        linkedHashMap.put("ARALIYA WHITE RAW 5KG","08-06");

        linkedHashMap.put("BASMATHI RICE 1KG","08-07");

        linkedHashMap.put("NIPUNA KEERI RAW 5KG","09-06");///

        linkedHashMap.put("NIPUNA KEERI SAMBA 10KG","09-07");
        linkedHashMap.put("NIPUNA KEERI SAMBA 5KG","09-07");
        linkedHashMap.put("NIPUNA NADU 10KG","09-07");
        linkedHashMap.put("NIPUNA NADU 5KG","09-07");

        linkedHashMap.put("NIPUNA SAMBA 10KG","10-06");
        linkedHashMap.put("NIPUNA SAMBA 5KG","10-06");

        linkedHashMap.put("NIPUNA WHITE RAW 10KG","10-07");///

        linkedHashMap.put("RATHNA KEERI SAMBA 10KG","11-06");///

        linkedHashMap.put("RATHNA RED KAKULU RICE 1KG","11-07");
        linkedHashMap.put("RATHNA RED KEKULU RICE 5KG","11-07");
        linkedHashMap.put("RATHNA RED SAMBA 5KG","11-07");
        linkedHashMap.put("RATHNA RED SAMBA ROW 1 KG","11-07");

        linkedHashMap.put("RATHNA SAMBA 10KG","12-06");///

        linkedHashMap.put("RATHNA SUDU KAKULU RICE 1KG","12-07");
        linkedHashMap.put("RATHNA SUDU KAKULU RICE 5 KG","12-07");

        linkedHashMap.put("DHALL 01 KG","13-06");

        linkedHashMap.put("DHALL PKT 1KG","13-07");

        linkedHashMap.put("SUGAR PKT 1KG","14-06");
        linkedHashMap.put("SUGER 1KG","14-06");

        linkedHashMap.put("SUGER BROWN 1KG","14-07");
        linkedHashMap.put("SUGER BROWN PKT 1KG","14-07");

        linkedHashMap.put("YOYO TOFFEE STRAWBERRY 1PCS ","05-14");///

        linkedHashMap.put("ASANKA  HONEY CASHEW 50","06-14");///

        linkedHashMap.put("AMBEWELA CHOCALATE 1L","07-14");///

        linkedHashMap.put("AMBEWELA YOGHURT 80ML","08-14");

        linkedHashMap.put("AMERICAN DRINKING WATER 1L","09-14");///

        linkedHashMap.put("ZENRA TEA 1KG","05-15");///

        linkedHashMap.put("LIPTON LAOJEE 100G","06-15");
        linkedHashMap.put("LIPTON LAOJEE 50G","06-15");

        linkedHashMap.put("ZENRA TEA 400G","07-15");///

        linkedHashMap.put("CEYLONTA 200G","08-15");
        linkedHashMap.put("CEYLONTA 500G","08-15");
        linkedHashMap.put("CEYLONTA TEA 100G","08-15");
        linkedHashMap.put("CEYLONTA TEA 50G","08-15");

        linkedHashMap.put("ZESTA FOIL PKT 100G","09-15");
        linkedHashMap.put("MALIBAN TEA 100G","09-15");
        linkedHashMap.put("MALIBAN TEA 20G","09-15");

        linkedHashMap.put("YELLOW TEA BAG 200G ","05-22");///

        linkedHashMap.put("ANCHOR 18G","06-22");

        linkedHashMap.put("ANCHOR FULL CREAM 1KG","07-22");
        linkedHashMap.put("ANCHOR FULL CREAM 250G","07-22");
        linkedHashMap.put("ANCHOR FULL CREAM 400G","07-22");

        linkedHashMap.put("ANCHOR FULL CREAM 75G","08-22");

        linkedHashMap.put("ANLENE MILK POW: NON FAT 400G","09-22");
        linkedHashMap.put("MALIBAN MILK POWDER 18G","09-22");
        linkedHashMap.put("MALIBAN MILK POWDER 60G","09-22");

        linkedHashMap.put("ARIYA FULL CREAM MILK POWDER 400G","05-23");

        linkedHashMap.put("ANCHOR NEWDALE CHOCOLATE  FLAVOURED MILK 180 ML","06-23");///

        linkedHashMap.put("ANCHOR PEDIAPRO 1-2 YEARS 1KG","07-23");///

        linkedHashMap.put("ANCHOR SHAPE-UP N/F 400G","08-23");

        linkedHashMap.put("DAILY FALUDA MILK 1L","09-23");///

        linkedHashMap.put("ELEPHANT SODA 1L","05-30");///

        linkedHashMap.put("COCA COLA  250ML","06-30");

        linkedHashMap.put("COCA COLA 1.5L","07-30");///

        linkedHashMap.put("ELEPHANT JAMBO JOLLY NECTA/CREAM SODA 60ML","08-30");///

        linkedHashMap.put("ELEPHANT HOUSE CREAM SODA 1L","09-30");///

        linkedHashMap.put("CADBURY BOUNVITA 200G BOTTLE","05-31");///

        linkedHashMap.put("CADBURY DAIRY MILK 60G","06-31");///

        linkedHashMap.put("CANDY MAN CHEWE 370G","07-31");
        linkedHashMap.put("CANDY MAN LOLLIPOP","07-31");

        linkedHashMap.put("CHOCLATE POWDER 1KG","08-31");

        linkedHashMap.put("CHOCO CUP","09-31");///

        linkedHashMap.put("DIANA ICING GEM 45G","05-38");
        linkedHashMap.put("DIANA ICING GEM 850G","05-38");

        linkedHashMap.put("DIANA STRAWBERRY / CUSTARD CRISPY 50G","06-38");

        linkedHashMap.put("CHERISH CHOCOLATE CREAM 400G","07-38");
        linkedHashMap.put("CHERISH CHOCOPEEPS 55G","07-38");

        linkedHashMap.put("CHERISH CLASSIC VANILLA 90G","08-38");
        linkedHashMap.put("CHERISH CREAM CRACKER 500G","08-38");

        linkedHashMap.put("CHERISH GINGER SNAPS  500G","09-38");

        linkedHashMap.put("CHERISH MILK SHORTIES 500G","05-39");
        linkedHashMap.put("CHERISH NICE 500G","05-39");

        linkedHashMap.put("CHERISH VANILLA PEEPS 55G","06-39");

        linkedHashMap.put("CHERISH WAFERS 450G","07-39");

        linkedHashMap.put("MALIBAN BRAN CRACKER 140G","08-39");
        linkedHashMap.put("MALIBAN BRAN CRACKER 210G","08-39");
        linkedHashMap.put("MALIBAN CHEESEBITS 25G","08-39");

        linkedHashMap.put("MALIBAN CHICK BITS 30G","09-39");
        linkedHashMap.put("MALIBAN CHICK BITS 80G","09-39");
        linkedHashMap.put("MALIBAN CHOCOLATE  CREAM 400G","09-39");
        linkedHashMap.put("MALIBAN CHOCOLATE CREAM 100G","09-39");

        linkedHashMap.put("MALIBAN CHOCOLATE PUFF 100G","12-38");
        linkedHashMap.put("MALIBAN CHOCOLATE PUFF 200G","12-38");
        linkedHashMap.put("MALIBAN CREAM CRACKER 125G","12-38");
        linkedHashMap.put("MALIBAN CREAM CRACKER 190G","12-38");

        linkedHashMap.put("MALIBAN CREAM CRACKER BUDDY 250 G","13-38");
        linkedHashMap.put("MALIBAN CUSTARD CREAM  400G","13-38");
        linkedHashMap.put("MALIBAN CUSTARD CREAM 100G","13-38");
        linkedHashMap.put("MALIBAN FALUDA MARIE 75G","13-38");
        linkedHashMap.put("MALIBAN FEEL GOOD SUGAR FREE 110G","13-38");

        linkedHashMap.put("MALIBAN FEEL GOOD SUGAR FREE 220G","14-38");
        linkedHashMap.put("MALIBAN FULL CREAM 400G","14-38");
        linkedHashMap.put("MALIBAN GEM 100G","14-38");
        linkedHashMap.put("MALIBAN GINGER BISCUIT 370G","14-38");
        linkedHashMap.put("MALIBAN GINGER BISCUIT 80G","14-38");
        linkedHashMap.put("MALIBAN GOLD MARIE 300G","14-38");
        linkedHashMap.put("MALIBAN GOLD MARIE 80 G","14-38");

        linkedHashMap.put("MALIBAN KRISCO PKT 170G","15-38");

        linkedHashMap.put("MALIBAN LEMON PUFF 100G","16-38");
        linkedHashMap.put("MALIBAN LEMON PUFF 200G","16-38");
        linkedHashMap.put("MALIBAN LIGHT MARIE 50G","16-38");
        linkedHashMap.put("MALIBAN MILK SHORTCAKE 85G","16-38");

        linkedHashMap.put("MALIBAN NICE 100G","12-39");
        linkedHashMap.put("MALIBAN ORANGE CREAM 100G","12-39");

        linkedHashMap.put("MALIBAN REAL DOUBLES MINT & CHO 110G","13-39");
        linkedHashMap.put("MALIBAN SMART CRACERS 85G","13-39");
        linkedHashMap.put("MALIBAN SMART CREAM CRACKER 500G","13-39");
        linkedHashMap.put("MALIBAN SNACKERS 30G","13-39");

        linkedHashMap.put("MALIBAN SORTIES 50G","14-39");

        linkedHashMap.put("MALIBAN SPICY CRACKERS 85G","15-39");
        linkedHashMap.put("MALIBAN WAFERS CHOCOLATE 100G","15-39");

        linkedHashMap.put("MALIBAN WAFERS VANILLA 100G","16-39");
        linkedHashMap.put("MALIBAN YOYO 50G","16-39");
        linkedHashMap.put("MALIBAN YOYO VANILA 50G","16-39");

        linkedHashMap.put("MC CURRIE - CHILLI PIECES 200G","12-30");///

        linkedHashMap.put("MC CURRIE - GORAKA 100G","13-30");///

        linkedHashMap.put("MC CURRY - CHICKEN CURRY 100G","14-30");///

        linkedHashMap.put("RAIGAM DELLAN KIRATA 60G","15-30");
        linkedHashMap.put("RAIGAM DEVANI BATHA - WHITE 350G","15-30");
        linkedHashMap.put("RAIGAM SOYA CHICKEN NATURAL 90G","15-30");
        linkedHashMap.put("RAIGAM SOYA CURRY 90G","15-30");
        linkedHashMap.put("RAIGAM SOYA MEAT CHICKEN 50G","15-30");

        linkedHashMap.put("RAIGAM CHI/SOYA DEW CHICKEN 90G + 20G","16-30");

        linkedHashMap.put("NOODLES 1KG","12-31");///

        linkedHashMap.put("NIKADO ATTA FLOUR 1KG","13-31");

        linkedHashMap.put("NIKADO PAPADAM SPECIAL","14-31");

        linkedHashMap.put("MD SAUCE CHILLI 750ML","14-31");///

        linkedHashMap.put("MD SAUCE TOMATO 15G","15-31");
        linkedHashMap.put("MD SAUCE TOMATO 200G","15-31");

        linkedHashMap.put("MD SEENI SAMBOL 400G","16-31");///

        linkedHashMap.put("WIJAYA CHILLI PIECES  500G","12-22");
        linkedHashMap.put("WIJAYA CHILLI PIECES 100G","12-22");
        linkedHashMap.put("WIJAYA CHILLI PIECES 50G","12-22");
        linkedHashMap.put("WIJAYA CHILLI POWDER 100G","12-22");
        linkedHashMap.put("WIJAYA CHILLI POWDER 250G","12-22");
        linkedHashMap.put("WIJAYA CHILLI POWDER 500G","12-22");
        linkedHashMap.put("WIJAYA CHILLI POWDER 50G","12-22");

        linkedHashMap.put("WIJAYA CURRY POWDER 100G","13-22");
        linkedHashMap.put("WIJAYA CURRY POWDER 250G","13-22");
        linkedHashMap.put("WIJAYA CURRY POWDER 500","13-22");
        linkedHashMap.put("WIJAYA CURRY POWDER 50G","13-22");

        linkedHashMap.put("WIJAYA M/CURRY POWDER MIX 50G","14-22");
        linkedHashMap.put("WIJAYA MUSTARD POWDER 50G","14-22");
        linkedHashMap.put("WIJAYA PEPPER POWDER 100G","14-22");
        linkedHashMap.put("WIJAYA PEPPER POWDER 25G","14-22");

        linkedHashMap.put("WIJAYA PEPPER POWDER 50G","15-22");
        linkedHashMap.put("WIJAYA R/ CHILLI POWDER 100G","15-22");
        linkedHashMap.put("WIJAYA R/CURRY POWDER 100G","15-22");

        linkedHashMap.put("WIJAYA R/POWDER 50G","16-22");
        linkedHashMap.put("WIJAYA ROASTED CURRY POWDER 500G","16-22");
        linkedHashMap.put("WIJAYA ROSTED CHILLI POWDER 50G","16-22");

        linkedHashMap.put("USWATTA PEPPERMINT 30G","12-23");///

        linkedHashMap.put("USWATTE FRUITY  JELLIES 500G","13-23");///

        linkedHashMap.put("USWATTE GLUCORASA 70G","14-23");
        linkedHashMap.put("USWATTE GLUCORASA JUJUBES  100G","14-23");
        linkedHashMap.put("USWATTE GLUCORASA JUJUBES 40G","14-23");

        linkedHashMap.put("USWATTE LOLLIPOP","14-23");///

        linkedHashMap.put("USWATTE WAFERS CHOCOLATE  CREAM 500G","15-23");///

        linkedHashMap.put("TWINS CHOCOLATE 45G","16-23");///

        linkedHashMap.put("TIARA LAYER VANILLA 480G","12-14");///

        linkedHashMap.put("TIARA O-KAY CHOCOLATE 15G","13-14");
        linkedHashMap.put("TIARA O-KAY CLASSIC 22G","13-14");
        linkedHashMap.put("TIARA ROLLO 30G","13-14");

        linkedHashMap.put("SUSTAGEN VANILLA 400G","14-14");

        linkedHashMap.put("SUPOSHA 250G","15-14");///

        linkedHashMap.put("SUNQUICK APPLE 330ML","16-14");///

        linkedHashMap.put("SUNQUICK MANDARIN 840ML","12-15");///

        linkedHashMap.put("SUNQUICK ORANGE 330ML","13-15");

        linkedHashMap.put("MARINA COOKING OIL 1L","14-15");
        linkedHashMap.put("MARINA SPREAD 18G","14-15");

        linkedHashMap.put("PASTA 1KG","15-15");
        linkedHashMap.put("PASTA HAT ELBOW  400G (P)","15-15");
        linkedHashMap.put("PASTA HAT SHELL BIG 400G (P)","15-15");
        linkedHashMap.put("PRIMA KOTT/MEE HOT & SPICY 80G","15-15");

        linkedHashMap.put("PRIMA NOODLES CHICKEN 85G","16-15");
        linkedHashMap.put("PRIMA NOODLES TOPPZE 80G","16-15");
        linkedHashMap.put("RUBASINGHE CHILLY PIECES 500G","16-15");
        linkedHashMap.put("RUBASINGHE CHILLY POWDER 500G","16-15");
        linkedHashMap.put("RUBASINGHE CURRY POWDER 500G","16-15");
        linkedHashMap.put("RUBASINGHE CURRY POWDER 50G","16-15");
        linkedHashMap.put("RUBASINGHE GORAKA CREAM 100G","16-15");
        linkedHashMap.put("RUBASINGHE MUSTARD POWDER 500G","16-15");
        linkedHashMap.put("RUBASINGHE ROASTED CHILLI POWDER 50G","16-15");
        linkedHashMap.put("RUBASINGHE ROSTED CURRY POWDER 100G","16-15");
        linkedHashMap.put("RUBASINGHE TURMERIC POWDER 50 G","16-15");
        linkedHashMap.put("RUBASINHGE CHILLI POWDER 100G","16-15");
        linkedHashMap.put("RUBASINHHE PEPPER POWDER 100G","16-15");

        linkedHashMap.put("SURF EXCEL 30G","05-44");
        linkedHashMap.put("SURF EXCEL WASH POWDER 150G","05-44");
        linkedHashMap.put("SURF EXCEL WASH POWDER 1KG","05-44");
        linkedHashMap.put("SUNLIGHT 70G","05-44");
        linkedHashMap.put("SUNLIGHT CARE 1KG","05-44");
        linkedHashMap.put("SUNLIGHT CARE 200G","05-44");
        linkedHashMap.put("SUNLIGHT CARE 40ML","05-44");
        linkedHashMap.put("SUNLIGHT CARE PEARLS 1L","05-44");
        linkedHashMap.put("SUNLIGHT CARE SOAP 120GM","05-44");
        linkedHashMap.put("SUNLIGHT DETERGEN POWDER 01KG","05-44");

        linkedHashMap.put("SUNLIGHT DETERGENT POWDER 400G","06-44");
        linkedHashMap.put("SUNLIGHT LEMON & JASMIN 1KG X","06-44");
        linkedHashMap.put("SUNLIGHT LEMON & ORENGE","06-44");
        linkedHashMap.put("SUNLIGHT ROSE FRESH 600G","06-44");
        linkedHashMap.put("SUNLIGHT SOAP PINK 120G","06-44");
        linkedHashMap.put("SUNLIGHT SOAP YELLOW 120G","06-44");
        linkedHashMap.put("SUNLIGHT SUPER DETREGENT 200G","06-44");
        linkedHashMap.put("SUNLIGHT WITH LIME & ORANGE 120G","06-44");
        linkedHashMap.put("SUNLIGHT WITH NIL MANEL 120G","06-44");

        linkedHashMap.put("SIGNAL HERBAL 160G","07-44");
        linkedHashMap.put("SIGNAL HERBAL 40G","07-44");
        linkedHashMap.put("SIGNAL HERBAL 70G","07-44");
        linkedHashMap.put("SIGNAL JUNIOR","07-44");
        linkedHashMap.put("SIGNAL NORMAL 120G","07-44");
        linkedHashMap.put("SIGNAL NORMAL 160G","07-44");


        linkedHashMap.put("SIGNAL NORMAL 70G","08-44");
        linkedHashMap.put("SIGNAL STRONG TEETH VALUE PACK","08-44");

        linkedHashMap.put("SENSDYNE FRESH MINT 130G","09-44");

        linkedHashMap.put("RAVAN B/HENNA 6G","10-44");
        linkedHashMap.put("RAVAN BLACK HAIR COLOUR SHAMPOO 25ML","10-44");

        linkedHashMap.put("PONDS AGE MIRACLE 100G","11-44");///

        linkedHashMap.put("PONDS WHITE BEAUT 23G","12-44");///

        linkedHashMap.put("NATURE SE: F/WASH CARROT 100ML","13-44");///

        linkedHashMap.put("NYLE NATURAL FACE WASH LEMON","14-44");///

        linkedHashMap.put("OLAY FOAMING CLEANSER 100G","14-44");///

        linkedHashMap.put("OLAY NATURAL WHITE FAIRNES D/C 50G","15-44");///










        return linkedHashMap;
    }


}
