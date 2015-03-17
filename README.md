RecyclerItemClickListener
=========================

Questions? Comments?  
https://twitter.com/lnikkila

-----

Handles clicks and long presses out of the box.

Use it like this:

```java
public class SampleActivity extends Activity
        implements RecyclerItemClickListener.OnItemClickListener {

    @Override
    protected void onStart() {
        // ...

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, this));

        // ...
    }

    @Override
    public void onItemClick(View childView, int position) {
        // Do something when an item is clicked.
    }

    @Override
    public void onItemLongPress(View childView, int position) {
        // Do another thing when an item is long pressed.
    }

}
```

Or like this:

```java
public class SampleActivity extends Activity {

    @Override
    protected void onStart() {
        // ...

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this,
                new OnItemClickListener()));

        // ...
    }

    private class OnItemClickListener extends RecyclerItemClickListener.SimpleOnItemClickListener {

        @Override
        public void onItemClick(View childView, int position) {
            // Do something when an item is clicked, or override something else.
        }

    }

}
```
