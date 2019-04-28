package capstoneproject.team.betaprototype.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cert {
    @Id
    public int psuid;
    public String cert;

    public Cert(int psuid, String cert) {
        this.psuid = psuid;
        this.cert = cert;
    }

    public Cert() {
    }
}
