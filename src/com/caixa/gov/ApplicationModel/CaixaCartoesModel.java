package com.caixa.gov.ApplicationModel;

import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.mobile.*;
import com.hp.lft.sdk.mobile.ApplicationDescription;
import com.hp.lft.sdk.mobile.Device;
import com.hp.lft.sdk.mobile.EditField;
import com.hp.lft.sdk.mobile.EditFieldDescription;
import org.junit.*;

import junit.framework.Assert;

public class CaixaCartoesModel {
	
	
	public static void login(Device device, String cartao, String senha) throws GeneralLeanFtException {

		EditField editFiledNumeroCartao = device.describe(Application.class, new ApplicationDescription.Builder()
			.identifier("br.gov.caixa.cartoes")
			.packaged(false).build())
		.describe(EditField.class, new EditFieldDescription.Builder()
			.className("Input")
			.mobileCenterIndex(0)
			.nativeClass("android.widget.EditText")
			.resourceId("br.gov.caixa.cartoes:id/textInputEditText").build());
		
    	editFiledNumeroCartao.tap();
    	editFiledNumeroCartao.setText(cartao);

    	EditField editFieldSenha = device.describe(Application.class, new ApplicationDescription.Builder()
    			.identifier("br.gov.caixa.cartoes")
    			.packaged(false).build())
    		.describe(EditField.class, new EditFieldDescription.Builder()
    			.className("Input")
    			.mobileCenterIndex(1)
    			.nativeClass("android.widget.EditText")
    			.resourceId("br.gov.caixa.cartoes:id/textInputEditText").build());
    	
    	editFiledNumeroCartao.tap();
    	editFieldSenha.setText(senha);
    	
    	Button confirmarButton = device.describe(Application.class, new ApplicationDescription.Builder()
    			.identifier("br.gov.caixa.cartoes")
    			.packaged(false).build())
    		.describe(Button.class, new ButtonDescription.Builder()
    			.className("Button")
    			.mobileCenterIndex(0)
    			.nativeClass("android.widget.Button")
    			.resourceId("br.gov.caixa.cartoes:id/confirmarBtn")
    			.text("CONFIRMAR").build());
    	
    	confirmarButton.tap();
	}
	
	public static void comoAtualizarTelefonePessoaFisica(Device device) throws GeneralLeanFtException {

		Button abrirMenu = device.describe(Application.class, new ApplicationDescription.Builder()
				.identifier("br.gov.caixa.cartoes")
				.packaged(false).build())
			.describe(Button.class, new ButtonDescription.Builder()
				.accessibilityId("Open navigation drawer")
				.className("ImageButton")
				.mobileCenterIndex(0)
				.nativeClass("android.widget.ImageButton").build());
		abrirMenu.tap();
		
		Label comoAtualizarOTelefoneLabel = device.describe(Application.class, new ApplicationDescription.Builder()
				.identifier("br.gov.caixa.cartoes")
				.packaged(false).build())
			.describe(Label.class, new LabelDescription.Builder()
				.className("Label")
				.mobileCenterIndex(2)
				.nativeClass("android.widget.TextView")
				.resourceId("br.gov.caixa.cartoes:id/textView")
				.text("Como Atualizar o Telefone").build());
		
		comoAtualizarOTelefoneLabel.tap();
			
		UiObject pessoaFisicaMenu = device.describe(Application.class, new ApplicationDescription.Builder()
				.identifier("br.gov.caixa.cartoes")
				.packaged(false).build())
			.describe(UiObject.class, new UiObjectDescription.Builder()
				.className("RadioButton")
				.mobileCenterIndex(0)
				.nativeClass("android.widget.RadioButton")
				.resourceId("br.gov.caixa.cartoes:id/tabPF")
				.text("PESSOA FÍSICA").build());
		pessoaFisicaMenu.tap();
		
		Label textoPessoaFisica = device.describe(Application.class, new ApplicationDescription.Builder()
				.identifier("br.gov.caixa.cartoes")
				.packaged(false).build())
			.describe(Label.class, new LabelDescription.Builder()
				.className("Label")
				.mobileCenterIndex(1)
				.nativeClass("android.widget.TextView")
				.text("Acesso por Titulares,\nPessoa Física").build());
		
		String resultado = textoPessoaFisica.getText().split(",")[1];
		Assert.assertEquals("Verificação ocorrida!", "Pessoa Física", resultado);
				
	}

	public static void comoAtualizarTelefonePessoaJuridica(Device device) throws GeneralLeanFtException {

		Button abrirMenu = device.describe(Application.class, new ApplicationDescription.Builder()
				.identifier("br.gov.caixa.cartoes")
				.packaged(false).build())
			.describe(Button.class, new ButtonDescription.Builder()
				.accessibilityId("Open navigation drawer")
				.className("ImageButton")
				.mobileCenterIndex(0)
				.nativeClass("android.widget.ImageButton").build());
		abrirMenu.tap();
		
		Label comoAtualizarOTelefoneLabel = device.describe(Application.class, new ApplicationDescription.Builder()
				.identifier("br.gov.caixa.cartoes")
				.packaged(false).build())
			.describe(Label.class, new LabelDescription.Builder()
				.className("Label")
				.mobileCenterIndex(2)
				.nativeClass("android.widget.TextView")
				.resourceId("br.gov.caixa.cartoes:id/textView")
				.text("Como Atualizar o Telefone").build());
		
		comoAtualizarOTelefoneLabel.tap();
		
		UiObject pessoaJuridicaLabel = device.describe(Application.class, new ApplicationDescription.Builder()
				.identifier("br.gov.caixa.cartoes")
				.packaged(false).build())
			.describe(UiObject.class, new UiObjectDescription.Builder()
				.className("RadioButton")
				.mobileCenterIndex(1)
				.nativeClass("android.widget.RadioButton")
				.resourceId("br.gov.caixa.cartoes:id/tabPJ")
				.text("PESSOA JURÍDICA").build());

		pessoaJuridicaLabel.tap();
		
	}

}
