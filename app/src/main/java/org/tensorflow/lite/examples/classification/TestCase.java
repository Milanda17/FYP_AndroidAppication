package org.tensorflow.lite.examples.classification;

import java.util.HashMap;
import java.util.Map;

public class TestCase {

    public static Map<String, String> dictionary = new HashMap<String, String>();

    public static String getServingSize( String item )
    {

        dictionary.put("AMBEWELA FRESH MILK  1L","100ml");
        dictionary.put("ANCHOR FULL CREAM 400G","100g");
        dictionary.put("DILMAH GREEN TEA","100g");
        dictionary.put("FORTUNE VEGETABLE OIL 1L","100g");
        dictionary.put("KEELLS BROWN SUGAR 1KG","100g");
        dictionary.put("KEELLS OVEN CASHEW 200G","100g");
        dictionary.put("MD MIXED FRUIT CHUTNEY 450G","100g");
        dictionary.put("PRIMA FLOUR 1KG","100g");
        dictionary.put("WIJAYA CHILLI POWDER 100G","100g");
        dictionary.put("WIJAYA PEPPER POWDER 100G","100g");

    String value = dictionary.get(item);
    return value;
    }

    public static String getEnergy( String item )
    {

        dictionary.put("AMBEWELA FRESH MILK  1L","282 kJ");
        dictionary.put("ANCHOR FULL CREAM 400G","2144 kJ");
        dictionary.put("DILMAH GREEN TEA","0");
        dictionary.put("FORTUNE VEGETABLE OIL 1L","900 kcal");
        dictionary.put("KEELLS BROWN SUGAR 1KG","398.80 kcal");
        dictionary.put("KEELLS OVEN CASHEW 200G","125.40 kcal");
        dictionary.put("MD MIXED FRUIT CHUTNEY 450G","24.3 kcal");
        dictionary.put("PRIMA FLOUR 1KG","0");
        dictionary.put("WIJAYA CHILLI POWDER 100G","264 kcal");
        dictionary.put("WIJAYA PEPPER POWDER 100G","323 kcal");

    String value = dictionary.get(item);
    return value;
    }

    public static String getTotalFat( String item )
    {

        dictionary.put("AMBEWELA FRESH MILK  1L","3.5");
        dictionary.put("ANCHOR FULL CREAM 400G","29.03");
        dictionary.put("DILMAH GREEN TEA","0");
        dictionary.put("FORTUNE VEGETABLE OIL 1L","100");
        dictionary.put("KEELLS BROWN SUGAR 1KG","0");
        dictionary.put("KEELLS OVEN CASHEW 200G","10.68");
        dictionary.put("MD MIXED FRUIT CHUTNEY 450G","0.01");
        dictionary.put("PRIMA FLOUR 1KG","0");
        dictionary.put("WIJAYA CHILLI POWDER 100G","2.1");
        dictionary.put("WIJAYA PEPPER POWDER 100G","3.6");

    String value = dictionary.get(item);
    return value;
    }

    public static String getCholesterol( String item )
    {

        dictionary.put("AMBEWELA FRESH MILK  1L","0");
        dictionary.put("ANCHOR FULL CREAM 400G","0");
        dictionary.put("DILMAH GREEN TEA","0");
        dictionary.put("FORTUNE VEGETABLE OIL 1L","42");
        dictionary.put("KEELLS BROWN SUGAR 1KG","0.01");
        dictionary.put("KEELLS OVEN CASHEW 200G","2.46");
        dictionary.put("MD MIXED FRUIT CHUTNEY 450G","0");
        dictionary.put("PRIMA FLOUR 1KG","0");
        dictionary.put("WIJAYA CHILLI POWDER 100G","0");
        dictionary.put("WIJAYA PEPPER POWDER 100G","0");

    String value = dictionary.get(item);
    return value;
    }

    public static String getProtein( String item )
    {

        dictionary.put("AMBEWELA FRESH MILK  1L","3.5");
        dictionary.put("ANCHOR FULL CREAM 400G","23.43");
        dictionary.put("DILMAH GREEN TEA","0");
        dictionary.put("FORTUNE VEGETABLE OIL 1L","0");
        dictionary.put("KEELLS BROWN SUGAR 1KG","0.3");
        dictionary.put("KEELLS OVEN CASHEW 200G","3.08");
        dictionary.put("MD MIXED FRUIT CHUTNEY 450G","0.1");
        dictionary.put("PRIMA FLOUR 1KG","0");
        dictionary.put("WIJAYA CHILLI POWDER 100G","14.6");
        dictionary.put("WIJAYA PEPPER POWDER 100G","12.6");

    String value = dictionary.get(item);
    return value;
    }

    public static String getCarbohydrate( String item )
    {

        dictionary.put("AMBEWELA FRESH MILK  1L","5.4");
        dictionary.put("ANCHOR FULL CREAM 400G","39.27");
        dictionary.put("DILMAH GREEN TEA","0");
        dictionary.put("FORTUNE VEGETABLE OIL 1L","0");
        dictionary.put("KEELLS BROWN SUGAR 1KG","99.40");
        dictionary.put("KEELLS OVEN CASHEW 200G","4.24");
        dictionary.put("MD MIXED FRUIT CHUTNEY 450G","5.95");
        dictionary.put("PRIMA FLOUR 1KG","0");
        dictionary.put("WIJAYA CHILLI POWDER 100G","46.7");
        dictionary.put("WIJAYA PEPPER POWDER 100G","6.0");

    String value = dictionary.get(item);
    return value;
    }

    public static String getFiber( String item )
    {

        dictionary.put("AMBEWELA FRESH MILK  1L","0");
        dictionary.put("ANCHOR FULL CREAM 400G","0");
        dictionary.put("DILMAH GREEN TEA","0");
        dictionary.put("FORTUNE VEGETABLE OIL 1L","0");
        dictionary.put("KEELLS BROWN SUGAR 1KG","0");
        dictionary.put("KEELLS OVEN CASHEW 200G","4.34");
        dictionary.put("MD MIXED FRUIT CHUTNEY 450G","0");
        dictionary.put("PRIMA FLOUR 1KG","0");
        dictionary.put("WIJAYA CHILLI POWDER 100G","0");
        dictionary.put("WIJAYA PEPPER POWDER 100G","0");

    String value = dictionary.get(item);
    return value;
    }

    public static String getSugar( String item )
    {

        dictionary.put("AMBEWELA FRESH MILK  1L","0");
        dictionary.put("ANCHOR FULL CREAM 400G","0");
        dictionary.put("DILMAH GREEN TEA","0");
        dictionary.put("FORTUNE VEGETABLE OIL 1L","0");
        dictionary.put("KEELLS BROWN SUGAR 1KG","99.80");
        dictionary.put("KEELLS OVEN CASHEW 200G","1.80");
        dictionary.put("MD MIXED FRUIT CHUTNEY 450G","20.4");
        dictionary.put("PRIMA FLOUR 1KG","0");
        dictionary.put("WIJAYA CHILLI POWDER 100G","0");
        dictionary.put("WIJAYA PEPPER POWDER 100G","0");

    String value = dictionary.get(item);
    return value;
    }
    public static String getSalt( String item )
    {

        dictionary.put("AMBEWELA FRESH MILK  1L","0");
        dictionary.put("ANCHOR FULL CREAM 400G","0.230");
        dictionary.put("DILMAH GREEN TEA","0");
        dictionary.put("FORTUNE VEGETABLE OIL 1L","0");
        dictionary.put("KEELLS BROWN SUGAR 1KG","0.8");
        dictionary.put("KEELLS OVEN CASHEW 200G","0.0046");
        dictionary.put("MD MIXED FRUIT CHUTNEY 450G","0.8");
        dictionary.put("PRIMA FLOUR 1KG","0");
        dictionary.put("WIJAYA CHILLI POWDER 100G","0");
        dictionary.put("WIJAYA PEPPER POWDER 100G","0");

    String value = dictionary.get(item);
    return value;
    }

    public static String getPrice( String item )
    {

        dictionary.put("AMBEWELA FRESH MILK  1L","Rs 220 \n Discount 5%");
        dictionary.put("ANCHOR FULL CREAM 400G","Rs 380 \n Discount 5%");
        dictionary.put("DILMAH GREEN TEA","Rs 175 \n Discount 5%");
        dictionary.put("FORTUNE VEGETABLE OIL 1L","Rs 520 \n Discount 5%");
        dictionary.put("KEELLS BROWN SUGAR 1KG","Rs 130 \n Discount 5%");
        dictionary.put("KEELLS OVEN CASHEW 200G","Rs 460 \n Discount 5%");
        dictionary.put("MD MIXED FRUIT CHUTNEY 450G","Rs 380 \n Discount 5%");
        dictionary.put("PRIMA FLOUR 1KG","Rs 75 \n Discount 5%");
        dictionary.put("WIJAYA CHILLI POWDER 100G","Rs 114 \n Discount 5%");
        dictionary.put("WIJAYA PEPPER POWDER 100G","Rs 230 \n Discount 5%");

    String value = dictionary.get(item);
    return value;
    }
}
