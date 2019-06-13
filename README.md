# Realm is a database that is the perfect alternative to SQLite. It’s is a NoSQL database designed for mobile platform.
# Its core consists of a self-contained C++ library. It supports Android and iOS both.

# Pros of Realm

Simplicity – Unlike SQLite the code is much shorter and concise. Besides, instead of using SQL, you just need to deal with objects and object trees in Realm.
Speed – Despite having a complex algorithm underneath, Realm performs CRUD operations faster. Obtaining objects is very fast since there is no deserialization
Live Objects – Realm has a no copy behaviour. All fetches are lazy, and the data is never copied until you perform some operations on them.
So till then from a query, all that you get is pointers to data. Hence all objects received from Realm are proxy to the database. Due to this, zero copy is achieved. Whenever you need to access the data you will always get the latest value.
Great Documentation – Realm documentation is clear and the community support is great.
JSON Support Built-in – Realm has JSON support. You can directly set data from JSON without the need to create model classes.
Security – You can secure the database using encryption.
Reactive Programming – You can observe changes in the database and update the UI accordingly. Using RxJava along with Realm just makes it a lot more simple and fun.
Built-in Adapters – Realm has Adapter classes for the Android UI components.


# Cons of Realm

No Auto-increment – You cannot auto-increment values in Realm.
Restrictions on Model classes – Besides the getter setter methods you cannot override methods like hashcode and equals in the Realm Model classes.
Threading – Real model classes can’t be passed from one thread to another. Hence you’ll have to query the class again on the different thread.
