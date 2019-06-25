package com.caixa.testes;

import org.junit.After;

import com.hp.lft.sdk.mobile.*;	
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.caixa.gov.ApplicationModel.CaixaCartoesModel;
import com.hp.lft.sdk.*;
import com.hp.lft.verifications.*;

import unittesting.*;

public class LeanFtTest extends UnitTestClassBase  {

    public LeanFtTest() {
        //Change this constructor to private if you supply your own public constructor
    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        instance = new LeanFtTest();
        globalSetup(LeanFtTest.class);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        globalTearDown();
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void loginTest() throws GeneralLeanFtException {
    	Device device = MobileLab.lockDeviceById("7783bdcdc3d874df4cd0d15cf085fe89814e38eb");
    	
    
    	/*Application app = device.describe(Application.class, new ApplicationDescription.Builder()
    			.identifier("br.gov.caixa.cartoes")
    			.packaged(true).build());
    		app.launch();
    		
            // cartao 5530960061239250
        	// Senha 4970
    		
    	CaixaCartoesModel.login(device, "5530960061239250", "4970");*/

    	EditField mobileEditEditField = device.describe(Application.class, new ApplicationDescription.Builder()
    			.identifier("br.gov.caixa.cartoes.credito")
    			.packaged(false).build())
    		.describe(EditField.class, new EditFieldDescription.Builder()
    			.className("Input")
    			.mobileCenterIndex(0)
    			.nativeClass("XCUIElementTypeTextField").build());
    	
    	
    }

    @Test
    public void menuComoAtualizarPessoaFisica() throws GeneralLeanFtException {
    	Device device = MobileLab.lockDeviceById("RQ8M406AMNZ");
    	
    
    	Application app = device.describe(Application.class, new ApplicationDescription.Builder()
    			.identifier("br.gov.caixa.cartoes")
    			.packaged(true).build());
    		app.launch();
    		
            // cartao 5530960061239250
        	// Senha 4970
    		
    	CaixaCartoesModel.comoAtualizarTelefonePessoaFisica(device);
    
    }

    

    
}