package sajid.com.architecturecomponents.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import sajid.com.roomdatabase.database.AppDatabase;
import sajid.com.roomdatabase.database.BorrowModel;

public class AddBorrowViewModel extends AndroidViewModel {

    private AppDatabase appDatabase;

    public AddBorrowViewModel(@NonNull Application application) {
        super(application);
        appDatabase = AppDatabase.getDatabase(this.getApplication());

    }

    public void addBorrow(final BorrowModel borrowModel) {
        new addAsyncTask(appDatabase).execute(borrowModel);
    }

    private static class addAsyncTask extends AsyncTask<BorrowModel, Void, Void> {

        private AppDatabase db;

        addAsyncTask(AppDatabase appDatabase) {
            db = appDatabase;
        }

        @Override
        protected Void doInBackground(final BorrowModel... params) {
            db.itemAndPersonModel().addBorrow(params[0]);
            return null;
        }

    }

}
