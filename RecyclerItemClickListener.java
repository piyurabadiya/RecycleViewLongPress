import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class RecyclerItemClickListener extends GestureDetector.SimpleOnGestureListener
        implements RecyclerView.OnItemTouchListener {

    protected GestureDetector gestureDetector;

    @Nullable
    protected OnItemClickListener listener;

    @Nullable
    protected View childView;

    protected int childViewPosition;

    public RecyclerItemClickListener(Context context, @Nullable OnItemClickListener listener) {
        this.gestureDetector = new GestureDetector(context, this);
        this.listener = listener;
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent event) {
        if (listener == null) {
            return false;
        }

        childView = view.findChildViewUnder(event.getX(), event.getY());

        if (childView == null) {
            return false;
        }

        childViewPosition = view.getChildPosition(childView);

        return gestureDetector.onTouchEvent(event);
    }

    @Override
    public void onTouchEvent(RecyclerView view, MotionEvent event) {}

    @Override
    public boolean onSingleTapUp(MotionEvent event) {
        if (childView != null && listener != null) {
            listener.onItemClick(childView, childViewPosition);
        }

        return true;
    }

    @Override
    public void onLongPress(MotionEvent event) {
        if (childView != null && listener != null) {
            listener.onItemLongPress(childView, childViewPosition);
        }
    }

    @Override
    public boolean onDown(MotionEvent event) {
        // Best practice to always return true here.
        // http://developer.android.com/training/gestures/detector.html#detect
        return true;
    }

    public interface OnItemClickListener {

        public void onItemClick(View view, int position);

        public void onItemLongPress(View view, int position);

    }

}
