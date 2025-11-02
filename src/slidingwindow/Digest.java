package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public abstract class Digest {

    private Map<byte[], byte[]> cache = new HashMap<byte[], byte[]>();

    public byte[] digest(byte[] input) {
        byte[] res = cache.get(input);
        if (res == null) {
            synchronized (cache) {
                res = cache.get(input);
                if (res == null) {
                    res = doDigest(input);
                    cache.put(input, res);
                }
            }
        }
        return res;
    }

    protected abstract byte[] doDigest(byte[] input);
}
