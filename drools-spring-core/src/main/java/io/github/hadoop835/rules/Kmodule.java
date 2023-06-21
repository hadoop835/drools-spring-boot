package io.github.hadoop835.rules;

import java.io.Serializable;

/**
 *
 * @author chenzhh
 */
public class Kmodule implements Serializable {
   private String  kbaseName;
   private String  kbasePackages;
   private String  ksessionName;
   private String  pomArtifactId;
   private String  pomGroupId;
   private String  pomVersion;

    public String getKbaseName() {
        return kbaseName;
    }

    public void setKbaseName(String kbaseName) {
        this.kbaseName = kbaseName;
    }

    public String getKbasePackages() {
        return kbasePackages;
    }

    public void setKbasePackages(String kbasePackages) {
        this.kbasePackages = kbasePackages;
    }

    public String getKsessionName() {
        return ksessionName;
    }

    public void setKsessionName(String ksessionName) {
        this.ksessionName = ksessionName;
    }

    public String getPomArtifactId() {
        return pomArtifactId;
    }

    public void setPomArtifactId(String pomArtifactId) {
        this.pomArtifactId = pomArtifactId;
    }

    public String getPomGroupId() {
        return pomGroupId;
    }

    public void setPomGroupId(String pomGroupId) {
        this.pomGroupId = pomGroupId;
    }

    public String getPomVersion() {
        return pomVersion;
    }

    public void setPomVersion(String pomVersion) {
        this.pomVersion = pomVersion;
    }
}
