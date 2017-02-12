package java8.function.predicate;

import java.math.BigDecimal;

public class Trade {


    private String instrument;
    private BigDecimal orderQty;
    private String status;

    public Trade() {
    }

    public Trade(String instrument, BigDecimal orderQty, String status){

        this.instrument = instrument;
        this.orderQty = orderQty;
        this.status = status;
    }

    public BigDecimal getOrderQty() {
        return orderQty;
    }

    public String getStatus() {
        return status;
    }

    public String getInstrument() {

        return instrument;
    }
}
