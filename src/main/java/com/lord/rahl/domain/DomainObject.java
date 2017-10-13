package com.lord.rahl.domain;

import java.time.Instant;
import java.util.Date;

/**
 * Created by lordrahl on 12/10/2017.
 */
public interface DomainObject {
    public void setId(Long id);
    public Long getId();

    public void setCreated(Date created);
    public Date getCreated();

    public void setUpdated(Date update);
    public Date getUpdated();
}
