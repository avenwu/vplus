package tv.danmaku.ijk.media.sample;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import avenwu.net.kotlinandroid.R;
import avenwu.net.kotlinandroid.VideoPlayerActivity;


public class FileListActivity extends ActionBarActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    ListView fileListView;
    VideoAdapter adapter;

    boolean sortByName = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_list);

        fileListView = (ListView) findViewById(R.id.fileListView);
        adapter = new VideoAdapter(this);
        fileListView.setAdapter(adapter);
        fileListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, final long id) {
                Intent intent = new Intent(FileListActivity.this, VideoPlayerActivity.class);
                intent.putExtra("videoPath", adapter.getVideoPath(position));
                intent.putExtra("videoTitle", adapter.getVideoTitle(position));
                startActivity(intent);
            }
        });

        getSupportLoaderManager().initLoader(1, null, this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        if (sortByName) {
            return new CursorLoader(this, MediaStore.Video.Media.getContentUri("external"), null, null, null,
                    "UPPER(" + MediaStore.Video.Media.DATA + ")");
        } else {
            return new CursorLoader(this, MediaStore.Video.Media.getContentUri("external"), null, null, null,
                    "UPPER(" + MediaStore.Video.Media.DISPLAY_NAME + ")");
        }
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        adapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    class VideoAdapter extends SimpleCursorAdapter {
        public VideoAdapter(Context context) {
            super(context, android.R.layout.simple_list_item_2, null,
                    new String[]{MediaStore.Video.Media.DISPLAY_NAME, MediaStore.Video.Media.DATA},
                    new int[]{android.R.id.text1, android.R.id.text2}, 0);
        }

        @Override
        public long getItemId(int position) {
            final Cursor cursor = getCursor();
            if (cursor.getCount() == 0 || position >= cursor.getCount()) {
                return 0;
            }
            cursor.moveToPosition(position);

            return cursor.getLong(0);
        }

        public String getVideoTitle(int position) {
            final Cursor cursor = getCursor();
            if (cursor.getCount() == 0) {
                return "";
            }
            cursor.moveToPosition(position);

            return cursor.getString(cursor.getColumnIndex(MediaStore.Video.Media.DISPLAY_NAME));
        }

        public String getVideoPath(int position) {
            final Cursor cursor = getCursor();
            if (cursor.getCount() == 0) {
                return "";
            }
            cursor.moveToPosition(position);

            return cursor.getString(cursor.getColumnIndex(MediaStore.Video.Media.DATA));
        }
    }
}
