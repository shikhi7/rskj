/*
 * This file is part of RskJ
 * Copyright (C) 2017 RSK Labs Ltd.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package co.rsk.core;

import org.ethereum.core.Account;

import java.util.List;

public class DisabledWallet implements Wallet {
    @Override
    public List<byte[]> getAccountAddresses() {
        throw new DisabledWalletException();
    }

    @Override
    public String[] getAccountAddressesAsHex() {
        throw new DisabledWalletException();
    }

    @Override
    public byte[] addAccount() {
        throw new DisabledWalletException();
    }

    @Override
    public byte[] addAccount(String passphrase) {
        throw new DisabledWalletException();
    }

    @Override
    public byte[] addAccount(Account account) {
        throw new DisabledWalletException();
    }

    @Override
    public Account getAccount(byte[] address) {
        throw new DisabledWalletException();
    }

    @Override
    public Account getAccount(byte[] address, String passphrase) {
        throw new DisabledWalletException();
    }

    @Override
    public boolean unlockAccount(byte[] address, String passphrase, long duration) {
        throw new DisabledWalletException();
    }

    @Override
    public boolean unlockAccount(byte[] address, String passphrase) {
        throw new DisabledWalletException();
    }

    @Override
    public boolean lockAccount(byte[] address) {
        throw new DisabledWalletException();
    }

    @Override
    public byte[] addAccountWithSeed(String seed) {
        throw new DisabledWalletException();
    }

    @Override
    public byte[] addAccountWithPrivateKey(byte[] privateKeyBytes) {
        throw new DisabledWalletException();
    }

    @Override
    public byte[] addAccountWithPrivateKey(byte[] privateKeyBytes, String passphrase) {
        throw new DisabledWalletException();
    }
}
