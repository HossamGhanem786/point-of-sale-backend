package com.point_of_sale.domain.audit.listener;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuditorAwareImpl implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		Optional<String> name = null;
		if (SecurityContextHolder.getContext().getAuthentication() != null) {
			name = Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication().getName());
		}

		return name != null ? name : Optional.of("System");
	}

}
