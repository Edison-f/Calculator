package math;

import echo.RequestHandler;

public class MathHandler extends RequestHandler {
    @Override
    protected String response(String msg) throws Exception {
        String[] split = msg.split(" ");
        if(!(split.length > 1))  {
            return "Incorrect format";
        }
        if(split[0].equals("add")) {
            return add(getParams(split)) + "";
        } else if (split[0].equals("mul")) {
            return multiply(getParams(split)) + "";
        } else if (split[0].equals("sub")) {
            return subtract(getParams(split)) + "";
        } else if (split[0].equals("div")) {
            return divide(getParams(split)) + "";
        }

        return "Unknown Operator";
    }

    private double[] getParams(String[] strings) {
        double[] result = new double[strings.length - 1];
        for (int i = 1; i < strings.length; i++) {
            try {
                result[i - 1] = Double.parseDouble(strings[i]);
            }
            catch (Exception e) {
                System.out.println("Incorrect number format");
                result[i - 1] = -1;
            }
        }
        return result;
    }

    public double add(double[] params) {
        double result = 0;
        for (double n :
                params) {
            result += n;
        }
        return result;
    }

    public double multiply(double[] params) {
        double result = 1.0;
        for (double n :
                params) {
//            System.out.println(n + " times " + result);
            result *= n;
        }
        return result;
    }

    public double subtract(double[] params) {
        double result = 0;
        for (double n :
                params) {
//            System.out.println(n + " minus " + result);
            result -= n;
        }
        return result;
    }

    public double divide(double[] params) {
        double result = 1.0;
        for (double n :
                params) {
//            System.out.println(n + " divided by " + result);
            result = result / n;
        }
        return result;
    }
}
