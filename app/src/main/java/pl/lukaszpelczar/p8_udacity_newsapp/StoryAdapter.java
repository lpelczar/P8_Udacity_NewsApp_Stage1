package pl.lukaszpelczar.p8_udacity_newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * An {@link StoryAdapter} knows how to create a list item layout for each story
 * in the data source (a list of {@link Story} objects).
 *
 * These list item layouts will be provided to an adapter view like ListView
 * to be displayed to the user.
 */
public class StoryAdapter extends ArrayAdapter<Story> {

    public StoryAdapter(Context context, List<Story> stories) {
        super(context, 0, stories);
    }

    /**
     * Returns a list item view that displays information about the story at the given position
     * in the list of stories.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.story_list_item, parent, false);
        }

        // Find the story at the given position in the list of stories
        Story currentStory = getItem(position);

        TextView sectionView = (TextView) listItemView.findViewById(R.id.section_name);
        sectionView.setText(currentStory.getSection());

        TextView authorView = (TextView) listItemView.findViewById(R.id.author_name);
        authorView.setText(currentStory.getAuthor());

        TextView titleView = (TextView) listItemView.findViewById(R.id.story_title);
        titleView.setText(currentStory.getTitle());

        TextView dateView = (TextView) listItemView.findViewById(R.id.story_date);
        String formattedDate = formatDate(currentStory.getDate());
        dateView.setText(formattedDate);

        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }

    /**
     * Return the formatted date string.
     */
    private String formatDate(String date) {
        String unformattedDate = date;
        String subDate = unformattedDate.substring(0,10);
        String subTime = unformattedDate.substring(11,19);
        return subDate + "  " + subTime;
    }

}
