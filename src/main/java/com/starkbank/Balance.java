package com.starkbank;

import com.starkbank.utils.Generator;
import com.starkbank.utils.Resource;
import com.starkbank.utils.Rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public final class Balance extends Resource {
    static ClassData data = new ClassData(Balance.class, "Balance");

    public int amount;
    public String currency;
    public String updated;

    /**
     * Balance object
     * <p>
     * The Balance object displays the current balance of the workspace,
     * which is the result of the sum of all transactions within this
     * workspace. The balance is never generated by the user, but it
     * can be retrieved to see the information available.
     * <p>
     * Attributes (return-only):
     * id [string, default null]: unique id returned when Boleto is created. ex: "5656565656565656"
     * amount [integer, default null]: current balance amount of the workspace in cents. ex: 200 (= R$ 2.00)
     * currency [string, default null]: currency of the current workspace. Expect others to be added eventually. ex: "BRL"
     * updated [string, default null]: update datetime for the balance. ex: "2020-03-10 10:30:00.000"
     */
    public Balance(int amount, String currency, String updated, String id) {
        super(id);
        this.amount = amount;
        this.currency = currency;
        this.updated = updated;
    }

    /**
     * Retrieve the Balance object
     * <p>
     * Receive the Balance object linked to your workspace in the Stark Bank API
     * <p>
     * Parameters:
     * user [Project object]: Project object. Not necessary if starkbank.User.defaultUser was set before function call
     * <p>
     * Return:
     * Balance object with updated attributes
     */
    public static Balance get(Project user) throws Exception {
        List<Balance> balanceList = new ArrayList<>();
        Generator<Balance> balances = Rest.getList(data, new HashMap<String, Object>(), user);
        for (Balance balance : balances) {
            balanceList.add(balance);
        }
        return balanceList.get(0);
    }

    public static Balance get() throws Exception {
        return Balance.get(null);
    }
}
