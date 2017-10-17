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

public interface Wallet {
    List<byte[]> getAccountAddresses();

    String[] getAccountAddressesAsHex();

    byte[] addAccount();

    byte[] addAccount(String passphrase);

    byte[] addAccount(Account account);

    Account getAccount(byte[] address);

    Account getAccount(byte[] address, String passphrase);

    boolean unlockAccount(byte[] address, String passphrase, long duration);

    boolean unlockAccount(byte[] address, String passphrase);

    boolean lockAccount(byte[] address);

    byte[] addAccountWithSeed(String seed);

    byte[] addAccountWithPrivateKey(byte[] privateKeyBytes);

    byte[] addAccountWithPrivateKey(byte[] privateKeyBytes, String passphrase);
}
