package com.lord.rahl.domain;

import java.time.Instant;

/**
 * Created by lordrahl on 12/10/2017.
 */
public interface DomainObject {
    public void setId(Long id);
    public Long getId();

    public void setCreated(Instant created);
    public Instant getCreated();

    public void setUpdated(Instant update);
    public Instant getUpdated();
}
