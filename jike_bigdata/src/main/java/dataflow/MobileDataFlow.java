package dataflow;

import com.google.common.base.Joiner;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * @author Vincent Wu
 * @datetime 2021/7/16 14:29
 */
@NoArgsConstructor
@Setter
@Getter
public class MobileDataFlow implements Writable {
    private Long upFlow;
    private Long downFlow;
    private Long sumFlow;

    public MobileDataFlow(Long upFlow, Long downFlow) {
        this.upFlow = upFlow;
        this.downFlow = downFlow;
        this.sumFlow = upFlow + downFlow;
    }

    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeLong(upFlow);
        dataOutput.writeLong(downFlow);
        dataOutput.writeLong(sumFlow);
    }

    public void readFields(DataInput dataInput) throws IOException {
        this.upFlow = dataInput.readLong();
        this.downFlow = dataInput.readLong();
        this.sumFlow = dataInput.readLong();
    }

    @Override
    public String toString() {
        return Joiner.on("\t").skipNulls().join(upFlow, downFlow, sumFlow);
    }
}
