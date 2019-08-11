package com.hyj.hyjurl.common;

import static org.junit.Assert.*;

import org.junit.Test;

public class Base62EncodeTest {

	@Test
	public void testEncode() {
		Base62Encode en = new Base62Encode();
        String result = en.encode(2);
        assertEquals("1", result);
	}

}
