package com.example.flowable;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class FlowableTestUtilsTest {

    @Test
    public void selectBase_returnsRoot() throws Exception {
        String root = "http://localhost:8080/flowable-rest";
        String res = FlowableTestUtils.selectBase(root, "u", "p");
        assertThat(res).isEqualTo(root);
    }

    @Test
    public void truncate_shortString_returnsSame() {
        String s = "short";
        assertThat(FlowableTestUtils.truncate(s, 10)).isEqualTo(s);
    }

    @Test
    public void truncate_longString_truncates() {
        String s = "0123456789ABCDEF";
        String t = FlowableTestUtils.truncate(s, 10);
        assertThat(t).startsWith("0123456789");
        assertThat(t).endsWith("... (truncated)");
    }
}
