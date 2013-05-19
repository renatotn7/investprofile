package br.pucrio.inf.les.investprofile.service.impl;

import br.pucrio.inf.les.investprofile.dao.LookupDao;
import br.pucrio.inf.les.investprofile.model.Role;
import br.pucrio.inf.les.investprofile.model.LabelValue;
import br.pucrio.inf.les.investprofile.Constants;
import org.jmock.Mock;

import java.util.ArrayList;
import java.util.List;


public class LookupManagerImplTest extends BaseManagerMockTestCase {
    private LookupManagerImpl mgr = new LookupManagerImpl();
    private Mock lookupDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        lookupDao = new Mock(LookupDao.class);
        mgr.setLookupDao((LookupDao) lookupDao.proxy());
    }

    public void testGetAllRoles() {
        log.debug("entered 'testGetAllRoles' method");

        // set expected behavior on dao
        Role role = new Role(Constants.ADMIN_ROLE);
        List<Role> testData = new ArrayList<Role>();
        testData.add(role);
        lookupDao.expects(once()).method("getRoles").withNoArguments().will(returnValue(testData));

        List<LabelValue> roles = mgr.getAllRoles();
        assertTrue(roles.size() > 0);
    }
}
