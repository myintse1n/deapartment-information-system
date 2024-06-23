package mm.edu.ec.mtu.config;

import java.util.EnumSet;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

import jakarta.servlet.DispatcherType;

public class WebSecurityApplicationInitializer extends AbstractSecurityWebApplicationInitializer{

	@Override
	protected EnumSet<DispatcherType> getSecurityDispatcherTypes() {
		return EnumSet.of(DispatcherType.ASYNC,DispatcherType.REQUEST);
	}
}
