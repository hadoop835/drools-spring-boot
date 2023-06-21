package io.github.hadoop835.drools;

import org.kie.api.runtime.KieSession;

/**
 * @author chenzhh
 */
public class KieSessionContext {
    private KieSession  kieSession;
    private Long  updateTime;

    /**
     *
     * @param kieSession
     * @param updateTime
     */
    public KieSessionContext(KieSession  kieSession,Long  updateTime){
        this.kieSession = kieSession;
        this.updateTime = updateTime;
    }

    public KieSession getKieSession() {
        return kieSession;
    }

    public Long getUpdateTime() {
        return updateTime;
    }
}
