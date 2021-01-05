package space.digitallab.testappforinstat.net;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

import space.digitallab.testappforinstat.R;
import space.digitallab.testappforinstat.dto.VideoUrls;

public class Adapter extends ArrayAdapter <VideoUrls> {
    private Context context;
    private List<VideoUrls> values;

    public Adapter(Context context, List<VideoUrls> values) {
        super(context, R.layout.video_model, values);

        this.context = context;
        this.values = values;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if (row == null) {
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.video_model, parent, false);
        }

        TextView videoName = (TextView) row.findViewById(R.id.video_name_value);
        TextView period = (TextView) row.findViewById(R.id.period_value);
        TextView quality = (TextView) row.findViewById(R.id.quality_value);
        TextView videoSize = (TextView) row.findViewById(R.id.video_size_value);
        TextView url = (TextView) row.findViewById(R.id.url);



        VideoUrls item = values.get(position);
        double d = item.getSize()/1048576;


        videoName.setText("название - " + item.getName());
        period.setText("тайм  - " + item.getPeriod());
        quality.setText("качество - " + item.getQuality());
        videoSize.setText("размер - " + d + " mB");
        url.setText("" + item.getUrl());

        return row;
    }
}

