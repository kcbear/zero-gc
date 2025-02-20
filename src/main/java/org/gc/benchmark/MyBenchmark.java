package org.gc.benchmark;

import org.agrona.collections.IntArrayList;
import org.openjdk.jmh.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *
 *
 Benchmark                            Mode  Cnt    Score   Error   Units
 MyBenchmark.agronaIntListIteration  thrpt       211.237          ops/us
 MyBenchmark.intArrayIteration       thrpt       244.721          ops/us
 MyBenchmark.intListIteration        thrpt       183.178          ops/us
 *
 */
@State(Scope.Benchmark)
public class MyBenchmark {
    int[] intArray = new int[]{1,4,5,6,9};
    List<Integer> intList = List.of(1,4,5,6,9);
    IntArrayList agronaList = new IntArrayList(intArray, intArray.length, -1);

    @Benchmark
    @Fork(1)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void intArrayIteration() {
        int sum = 0;
        for (int i: intArray) {
            sum +=i;
        }
    }


    @Benchmark
    @Fork(1)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void intListIteration() {
        int sum = 0;
        for (int i: intList) {
            sum +=i;
        }
    }

    @Benchmark
    @Fork(1)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void agronaIntListIteration() {
        int sum = 0;
        for (int i: agronaList) {
            sum +=i;
        }
    }

}
