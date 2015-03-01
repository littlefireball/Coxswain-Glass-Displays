package engs75.coxswaintestscreens;

import com.google.android.glass.media.Sounds;
import com.google.android.glass.widget.CardBuilder;
import com.google.android.glass.widget.CardScrollAdapter;
import com.google.android.glass.widget.CardScrollView;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

/**
 * An {@link Activity} showing a tuggable "Hello World!" card.
 * <p/>
 * The main content view is composed of a one-card {@link CardScrollView} that provides tugging
 * feedback to the user when swipe gestures are detected.
 * If your Glassware intends to intercept swipe gestures, you should set the content view directly
 * and use a {@link com.google.android.glass.touchpad.GestureDetector}.
 *
 * @see <a href="https://developers.google.com/glass/develop/gdk/touch">GDK Developer Guide</a>
 */
public class MainActivity extends Activity {

    /**
     * {@link CardScrollView} to use as the main content view.
     */
    private CardScrollView mCardScrollView;
    private List<CardBuilder> mCards;
    private ExampleCardScrollAdapter mAdapter;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
//        setContentView(new TuggableView(this,R.layout.layout_1));
        setContentView(R.layout.layout_1);


        createCards();

        mCardScrollView = new CardScrollView(this);
        mAdapter = new ExampleCardScrollAdapter();
        mCardScrollView.setAdapter(mAdapter);
        mCardScrollView.activate();
        setContentView(mCardScrollView);
    }

    private void createCards() {
        mCards = new ArrayList<CardBuilder>();

        mCards.add(new CardBuilder(this, CardBuilder.Layout.TEXT)
                .setText("This is my tester card")
                .setFootnote("It has a footnote")
                .setTimestamp("today"));


        mCards.add(new CardBuilder(this, CardBuilder.Layout.EMBED_INSIDE)
                .setEmbeddedLayout(R.layout.layout_1)
                .setFootnote("5374 meters")
                .setTimestamp("464 strokes"));

    }

    @Override
    protected void onResume() {
        super.onResume();
        mCardScrollView.activate();
    }

    @Override
    protected void onPause() {
        mCardScrollView.deactivate();
        super.onPause();
    }


    private class ExampleCardScrollAdapter extends CardScrollAdapter {

        @Override
        public int getPosition(Object item) {
            return mCards.indexOf(item);
        }

        @Override
        public int getCount() {
            return mCards.size();
        }

        @Override
        public Object getItem(int position) {
            return mCards.get(position);
        }

        @Override
        public int getViewTypeCount() {
            return CardBuilder.getViewTypeCount();
        }

        @Override
        public int getItemViewType(int position) {
            return mCards.get(position).getItemViewType();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return mCards.get(position).getView(convertView, parent);
        }
    }
//    public class TuggableView extends CardScrollView {
//
//        private final View mContentView;
//
//        /**
//         * Initializes a TuggableView that uses the specified layout
//         * resource for its user interface.
//         */
//        public TuggableView(Context context, int layoutResId) {
//            this(context, LayoutInflater.from(context)
//                    .inflate(layoutResId, null));
//        }
//
//        /**
//         * Initializes a TuggableView that uses the specified view
//         * for its user interface.
//         */
//        public TuggableView(Context context, View view) {
//            super(context);
//
//            mContentView = view;
//            setAdapter(new SingleCardAdapter());
//            activate();
//        }
//
//        /**
//         * Overridden to return false so that all motion events still
//         * bubble up to the activity's onGenericMotionEvent() method after
//         * they are handled by the card scroller. This allows the activity
//         * to handle TAP gestures using a GestureDetector instead of the
//         * card scroller's OnItemClickedListener.
//         */
//        @Override
//        protected boolean dispatchGenericFocusedEvent(MotionEvent event) {
//            super.dispatchGenericFocusedEvent(event);
//            return false;
//        }
//
//        /** Holds the single "card" inside the card scroll view. */
//        private class SingleCardAdapter extends CardScrollAdapter {
//
//            @Override
//            public int getPosition(Object item) {
//                return 0;
//            }
//
//            @Override
//            public int getCount() {
//                return 1;
//            }
//
//            @Override
//            public Object getItem(int position) {
//                return mContentView;
//            }
//
//            @Override
//            public View getView(int position, View recycleView,
//                                ViewGroup parent) {
//                return mContentView;
//            }
//        }
//    }
}
            
    
        
//        mCardScrollView.setAdapter(new CardScrollAdapter() {
//            @Override
//            public int getCount() {
//                return 1;
//            }
//
//            @Override
//            public Object getItem(int position) {
//                return mView;
//            }
//
//            @Override
//            public View getView(int position, View convertView, ViewGroup parent) {
//                return mView;
//            }
//
//            @Override
//            public int getPosition(Object item) {
//                if (mView.equals(item)) {
//                    return 0;
//                }
//                return AdapterView.INVALID_POSITION;
//            }
//        });

//        setContentView(mCardScroller);
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        mCardScroller.activate();
//    }
//
//    @Override
//    protected void onPause() {
//        mCardScroller.deactivate();
//        super.onPause();
//    }
//
