package org.zalando.fauxpas;

import lombok.SneakyThrows;
import org.apiguardian.api.API;
import javax.annotation.Nullable;
import static org.apiguardian.api.API.Status.MAINTAINED;
import static org.apiguardian.api.API.Status.STABLE;

public final class TryWith {

    private TryWith() {
    }

    @API(status = MAINTAINED)
    public static <O extends AutoCloseable, I extends AutoCloseable, X extends Throwable> void tryWith(@Nullable final O outer, @Nullable final I inner, final ThrowingBiConsumer<O, I, X> consumer) throws X {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @API(status = STABLE)
    public static <R extends AutoCloseable, X extends Throwable> void tryWith(@Nullable final R resource, final ThrowingConsumer<R, X> consumer) throws X {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @API(status = MAINTAINED)
    public static <O extends AutoCloseable, I extends AutoCloseable, T, X extends Throwable> T tryWith(@Nullable final O outer, @Nullable final I inner, final ThrowingBiFunction<O, I, T, X> function) throws X {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @API(status = STABLE)
    public static <R extends AutoCloseable, T, X extends Throwable> T tryWith(@Nullable final R resource, final ThrowingFunction<R, T, X> supplier) throws X {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SneakyThrows
    private static void tryClose(@Nullable final AutoCloseable resource) {
        if (resource == null) {
            return;
        }
        resource.close();
    }

    @SuppressWarnings("unchecked")
    private static <X extends Throwable> X cast(final Throwable e) {
        return (X) e;
    }

    private static <X extends Throwable> X tryClose(@Nullable final AutoCloseable closeable, final X e) {
        if (closeable == null) {
            return e;
        }
        try {
            closeable.close();
        } catch (final Throwable inner) {
            e.addSuppressed(inner);
        }
        return e;
    }
}
