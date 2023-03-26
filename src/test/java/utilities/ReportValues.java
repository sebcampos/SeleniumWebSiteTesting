package utilities;
import java.math.BigDecimal;


public class ReportValues
{
    private String category;

    private int frequency;
    private int upper;
    private int lower;
    private BigDecimal net_profit;
    private int total_trades;
    private BigDecimal percent_profitable;
    private BigDecimal profit_factor;
    private BigDecimal max_draw_down;
    private BigDecimal max_run_up;
    private BigDecimal avg_draw_down;
    private BigDecimal avg_run_up;
    private String cumulative_profit;
    private BigDecimal r_squared;
    private BigDecimal slope;
    private BigDecimal std_error;


    public String getCategory() {
        return category;
    }

    public int getFrequency() {
        return frequency;
    }

    public int getUpper() {
        return upper;
    }

    public int getLower() {
        return lower;
    }

    public BigDecimal getNetProfit() {
        return net_profit;
    }

    public int getTotalTrades() {
        return total_trades;
    }

    public BigDecimal getPercentProfitable() {
        return percent_profitable;
    }

    public BigDecimal getProfitFactor() {
        return profit_factor;
    }

    public BigDecimal getMaxDrawDown() {
        return max_draw_down;
    }

    public BigDecimal getMaxRunUp() {
        return max_run_up;
    }

    public BigDecimal getAvgDrawDown() {
        return avg_draw_down;
    }

    public BigDecimal getAvgRunUp() {
        return avg_run_up;
    }

    public String getCumulativeProfit() {
        return cumulative_profit;
    }

    public BigDecimal getRSquared() {
        return r_squared;
    }

    public BigDecimal getSlope() {
        return slope;
    }

    public BigDecimal getStdError() {
        return std_error;
    }
}
