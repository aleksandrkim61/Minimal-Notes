package aleksandrkim.ArchComponentsTest.NoteFeed;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import aleksandrkim.ArchComponentsTest.Db.NoteRoom;
import aleksandrkim.ArchComponentsTest.R;

/**
 * Created by Aleksandr Kim on 20 Apr, 2018 4:37 PM for ArchComponentsTest
 */

public class NoteFeedVH extends RecyclerView.ViewHolder {
    private int id;
    private TextView title, content, date;
    private View colorStrip;
    private ConstraintLayout viewForeground;
    private ImageView deleteIcon;

    NoteFeedVH(View itemView) {
        super(itemView);
        colorStrip = itemView.findViewById(R.id.color_strip);
        title = itemView.findViewById(R.id.tv_title);
        content = itemView.findViewById(R.id.tv_content);
        date = itemView.findViewById(R.id.tv_date);
        viewForeground = itemView.findViewById(R.id.view_foreground);
        deleteIcon = itemView.findViewById(R.id.delete_icon);
    }

    public int getId(){
        return id;
    }

    ConstraintLayout getViewForeground(){
        return viewForeground;
    }

    ImageView getDeleteIcon(){
        return deleteIcon;
    }

    void bind(NoteRoom note) {
        id = note.getId();
        title.setText(note.getTitle());
        if (title.getText().length() == 0)
            title.setVisibility(View.GONE);
        content.setText(note.getContent());
        date.setText(note.getLastModifiedString());
        colorStrip.getBackground().setTint(note.getColor());
    }

    void clear() {
        itemView.invalidate();
        title.invalidate();
        content.invalidate();
        date.invalidate();
        colorStrip.invalidate();
        viewForeground.invalidate();
        deleteIcon.invalidate();
    }
}