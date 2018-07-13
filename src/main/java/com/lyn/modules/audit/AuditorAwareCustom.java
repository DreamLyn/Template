package com.lyn.modules.audit;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareCustom implements AuditorAware<Long>{
    @Override
    public Optional<Long> getCurrentAuditor() {
        return Optional.of(1L);
    }
}
