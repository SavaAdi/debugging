package eu.unicreditgroup.debugging.playtime;

public class SetExcepBreakpoint {

    enum DISCOUNT_TYPE {
        SMALL, AVERAGE, SUMMER, PREMIUM;
    }

    public static void main(String[] args) {
        System.out.println("Your discount is " + getDiscount(DISCOUNT_TYPE.AVERAGE));
    }

    public static int getDiscount(DISCOUNT_TYPE discount_type) {
        int discount = switch (discount_type) {
            case SMALL -> 1;
            case AVERAGE -> 2;
            case SUMMER, PREMIUM -> {
                System.out.println("A great discount!!!!");
                yield 3;
            }
            default -> {
                throw new IllegalArgumentException("Unknown discount type");
            }
        };

        return 1/(2 - discount);
    }
}
