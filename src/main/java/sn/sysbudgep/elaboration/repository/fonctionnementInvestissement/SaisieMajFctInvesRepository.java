package sn.sysbudgep.elaboration.repository.fonctionnementInvestissement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.sysbudgep.elaboration.entity.fonctionnementInvestissement.SaisieMajFctInves;

@Repository
public interface SaisieMajFctInvesRepository extends JpaRepository<SaisieMajFctInves, String> {

}