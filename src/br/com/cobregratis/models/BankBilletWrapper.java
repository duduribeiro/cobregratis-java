package br.com.cobregratis.models;

import com.google.gson.annotations.SerializedName;

public class BankBilletWrapper {
	@SerializedName("bank_billet")
	private BankBillet bankBillet;

	public BankBillet getBankBillet() {
		return bankBillet;
	}

	public void setBankBillet(BankBillet bankBillet) {
		this.bankBillet = bankBillet;
	}
}
