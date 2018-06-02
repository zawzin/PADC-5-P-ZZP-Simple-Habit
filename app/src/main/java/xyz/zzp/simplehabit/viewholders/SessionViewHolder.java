package xyz.zzp.simplehabit.viewholders;

import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import xyz.zzp.simplehabit.R;
import xyz.zzp.simplehabit.data.vo.SessionVO;

public class SessionViewHolder extends BaseViewHolder<SessionVO> {

    @BindView(R.id.tv_session_no)
    TextView tvSessionNo;

    @BindView(R.id.tv_session_name)
    TextView tvSessionName;

    @BindView(R.id.tv_session_time)
    TextView tvSessiontime;

    public SessionViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(SessionVO data) {
        tvSessionNo.setText(data.getSessionId());
        tvSessionName.setText(data.getTitle());
        String timeLength = data.getLengthInSeconds()/60+":"+data.getLengthInSeconds()%60;
        tvSessiontime.setText(timeLength);
    }

    @Override
    public void onClick(View view) {

    }
}
