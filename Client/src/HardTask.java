import java.io.Serializable;

public class HardTask implements Task<Integer>, Serializable {
    public Integer execute() {
        Integer result;

        for (result = 0; result < Integer.MAX_VALUE; ++result);

        return result;
    }
}
