package com.hunterdavis.adventureneverstops.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.annotation.UiThread;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hunterdavis.adventureneverstops.ANSApplication;
import com.hunterdavis.adventureneverstops.R;
import com.hunterdavis.adventureneverstops.events.HeroUpdatedEvent;
import com.squareup.otto.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;


public class PrologueView extends LinearLayout {


    @BindView(R.id.history_text)
    TextView historyText;

    @BindView(R.id.current_exp)
    TextView currentExp;

    public PrologueView(Context context) {
        super(context);
        init(null, 0);
    }

    public PrologueView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public PrologueView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        // Load attributes
        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.PrologueView, defStyle, 0);


        a.recycle();

        View v = View.inflate(getContext(), R.layout.prologue_view, this);
        ButterKnife.bind(v, this);

        ANSApplication.getEventBus().register(this);

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // TODO: consider storing these as member variables to reduce
        // allocations per draw cycle.
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();

        int contentWidth = getWidth() - paddingLeft - paddingRight;
        int contentHeight = getHeight() - paddingTop - paddingBottom;

    }



    @Subscribe
    public void updateHero(HeroUpdatedEvent heroUpdatedEvent) {
        setCurrentHeroExp(heroUpdatedEvent);
        updateHistoryText(heroUpdatedEvent);
    }

    private void updateHistoryText(HeroUpdatedEvent heroUpdatedEvent) {
        historyText.setText(heroUpdatedEvent.hero.backStory());
    }

    @UiThread
    private void setCurrentHeroExp(HeroUpdatedEvent heroUpdatedEvent) {
        currentExp.setText(getContext().getString(R.string.current_experience, heroUpdatedEvent.hero.experience));
    }


}
