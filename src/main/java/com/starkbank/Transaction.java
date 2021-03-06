package com.starkbank;

import com.starkbank.utils.Generator;
import com.starkbank.utils.Resource;
import com.starkbank.utils.Rest;

import java.util.HashMap;
import java.util.List;


public final class Transaction extends Resource {
    static ClassData data = new ClassData(Transaction.class, "Transaction");

    public int amount;
    public String description;
    public String externalId;
    public String senderId;
    public String receiverId;
    public String[] tags;
    public Integer fee;
    public String created;
    public String source;

    /**
     * Transaction object
     * <p>
     * A Transaction is a transfer of funds between workspaces inside Stark Bank.
     * Transactions created by the user are only for internal transactions.
     * Other operations (such as transfer or charge-payment) will automatically
     * create a transaction for the user which can be retrieved for the statement.
     * When you initialize a Transaction, the entity will not be automatically
     * created in the Stark Bank API. The "create" function sends the objects
     * to the Stark Bank API and returns the list of created objects.
     * <p>
     * Parameters:
     * amount [integer]: amount in cents to be transferred. ex: 1234 (= R$ 12.34)
     * description [string]: text to be displayed in the receiver and the sender statements (Min. 10 characters). ex: "funds redistribution"
     * externalId [string]: unique id, generated by user, to avoid duplicated transactions. ex: "transaction ABC 2020-03-30"
     * receivedId [string]: unique id of the receiving workspace. ex: "5656565656565656"
     * tags [list of strings]: list of strings for reference when searching transactions (may be empty). ex: ["abc", "test"]
     * Attributes (return-only):
     * senderId [string]: unique id of the sending workspace. ex: "5656565656565656"
     * source [string, default null]: unique locator of the related entity in the API reference
     * id [string, default null]: unique id returned when Transaction is created. ex: "7656565656565656"
     * fee [integer, default null]: fee charged when transfer is created. ex: 200 (= R$ 2.00)
     * created [string, default null]: creation datetime for the boleto. ex: "2020-03-10 10:30:00.000"
     */
    public Transaction(int amount, String description, String externalId, String receiverId, String senderId,
                       String[] tags, int fee, String created, String source, String id) {
        super(id);
        this.amount = amount;
        this.description = description;
        this.externalId = externalId;
        this.receiverId = receiverId;
        this.senderId = senderId;
        this.tags = tags;
        this.fee = fee;
        this.created = created;
        this.source = source;
    }

    /**
     * Transaction object
     * <p>
     * A Transaction is a transfer of funds between workspaces inside Stark Bank.
     * Transactions created by the user are only for internal transactions.
     * Other operations (such as transfer or charge-payment) will automatically
     * create a transaction for the user which can be retrieved for the statement.
     * When you initialize a Transaction, the entity will not be automatically
     * created in the Stark Bank API. The "create" function sends the objects
     * to the Stark Bank API and returns the list of created objects.
     * <p>
     * Parameters:
     * amount [integer]: amount in cents to be transferred. ex: 1234 (= R$ 12.34)
     * description [string]: text to be displayed in the receiver and the sender statements (Min. 10 characters). ex: "funds redistribution"
     * externalId [string]: unique id, generated by user, to avoid duplicated transactions. ex: "transaction ABC 2020-03-30"
     * receivedId [string]: unique id of the receiving workspace. ex: "5656565656565656"
     * <p>
     * Parameters (optional):
     * senderId [string]: unique id of the sending workspace. ex: "5656565656565656"
     * tags [list of strings]: list of strings for reference when searching transactions (may be empty). ex: ["abc", "test"]
     * Attributes (return-only):
     * source [string, default null]: unique locator of the related entity in the API reference
     * id [string, default null]: unique id returned when Transaction is created. ex: "7656565656565656"
     * fee [integer, default null]: fee charged when transfer is created. ex: 200 (= R$ 2.00)
     * created [string, default null]: creation datetime for the boleto. ex: "2020-03-10 10:30:00.000"
     */
    public Transaction(HashMap<String, Object> data) {
        super(null);
        this.amount = (int) data.get("amount");
        this.description = (String) data.get("description");
        this.externalId = (String) data.get("externalId");
        this.receiverId = (String) data.get("receiverId");
        this.tags = (String[]) data.get("tags");
    }

    /**
     * Retrieve a specific Transaction
     * <p>
     * Receive a single Transaction object previously created in the Stark Bank API by passing its id
     * <p>
     * Parameters:
     * id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * Transaction object with updated attributes
     */
    public static Transaction get(String id) throws Exception {
        return Transaction.get(id, null);
    }

    /**
     * Retrieve a specific Transaction
     * <p>
     * Receive a single Transaction object previously created in the Stark Bank API by passing its id
     * <p>
     * Parameters:
     * id [string]: object unique id. ex: "5656565656565656"
     * user [Project object]: Project object. Not necessary if starkbank.User.defaultUser was set before function call
     * <p>
     * Return:
     * Transaction object with updated attributes
     */
    public static Transaction get(String id, Project user) throws Exception {
        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve Transactions
     * <p>
     * Receive a generator of Transaction objects previously created in the Stark Bank API
     * <p>
     * Parameters:
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * externalIds [list of strings, default null]: list of external ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * <p>
     * Return:
     * generator of Transaction objects with updated attributes
     */
    public static Generator<Transaction> query(HashMap<String, Object> params) throws Exception {
        return Transaction.query(params, null);
    }

    /**
     * Retrieve Transactions
     * <p>
     * Receive a generator of Transaction objects previously created in the Stark Bank API
     * <p>
     * Parameters:
     * user [Project object, default null]: Project object. Not necessary if starkbank.User.defaultUser was set before function call
     * <p>
     * Return:
     * generator of Transaction objects with updated attributes
     */
    public static Generator<Transaction> query(Project user) throws Exception {
        return Transaction.query(new HashMap<>(), user);
    }

    /**
     * Retrieve Transactions
     * <p>
     * Receive a generator of Transaction objects previously created in the Stark Bank API
     * <p>
     * Return:
     * generator of Transaction objects with updated attributes
     */
    public static Generator<Transaction> query() throws Exception {
        return Transaction.query(new HashMap<>(), null);
    }

    /**
     * Retrieve Transactions
     * <p>
     * Receive a generator of Transaction objects previously created in the Stark Bank API
     * <p>
     * Parameters:
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * externalIds [list of strings, default null]: list of external ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * user [Project object, default null]: Project object. Not necessary if starkbank.User.defaultUser was set before function call
     * <p>
     * Return:
     * generator of Transaction objects with updated attributes
     */
    public static Generator<Transaction> query(HashMap<String, Object> params, Project user) throws Exception {
        return Rest.getList(data, params, user);
    }

    /**
     * Create Transactions
     * <p>
     * Send a list of Transaction objects for creation in the Stark Bank API
     * <p>
     * Parameters:
     * transactions [list of Transaction objects]: list of Transaction objects to be created in the API
     * <p>
     * Return:
     * list of Transaction objects with updated attributes
     */
    public static List<Transaction> create(List<Transaction> transactions) throws Exception {
        return Transaction.create(transactions, null);
    }

    /**
     * Create Transactions
     * <p>
     * Send a list of Transaction objects for creation in the Stark Bank API
     * <p>
     * Parameters:
     * transactions [list of Transaction objects]: list of Transaction objects to be created in the API
     * user [Project object]: Project object. Not necessary if starkbank.User.defaultUser was set before function call
     * <p>
     * Return:
     * list of Transaction objects with updated attributes
     */
    public static List<Transaction> create(List<Transaction> transactions, Project user) throws Exception {
        return Rest.post(data, transactions, user);
    }
}
