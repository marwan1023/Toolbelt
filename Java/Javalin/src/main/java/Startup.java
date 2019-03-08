import com.google.inject.Inject;
import io.alzuma.AppEntrypoint;
import io.alzuma.EntrypointType;

import javax.inject.Singleton;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@Singleton
public class Startup {
    @Inject(optional = true)
    private Map<EntrypointType, AppEntrypoint> entrypoints = Collections.emptyMap();

    public void boot(EntrypointType entrypointType, String[] args) {
        Optional<AppEntrypoint> entryPoint = Optional.ofNullable(entrypoints.get(entrypointType));
        entryPoint.orElseThrow(() -> new RuntimeException("Entrypoint not defined")).boot(args);
    }
}
