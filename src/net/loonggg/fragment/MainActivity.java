package net.loonggg.fragment;

import net.loonggg.view.SlidingMenu;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;

public class MainActivity extends FragmentActivity {
	private SlidingMenu mSlidingMenu;// �������view
	private LeftFragment leftFragment; // ����������Ƭ��view
	private RightFragment rightFragment; // �Ҳ��������Ƭ��view
	private SampleListFragment centerFragment;// �м�������Ƭ����view
	private FragmentTransaction ft; // ��Ƭ�����������

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// ȥ������
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		mSlidingMenu = (SlidingMenu) findViewById(R.id.slidingMenu);
		mSlidingMenu.setLeftView(getLayoutInflater().inflate(
				R.layout.left_frame, null));
		mSlidingMenu.setRightView(getLayoutInflater().inflate(
				R.layout.right_frame, null));
		mSlidingMenu.setCenterView(getLayoutInflater().inflate(
				R.layout.center_frame, null));

		ft = this.getSupportFragmentManager().beginTransaction();
		leftFragment = new LeftFragment();
		rightFragment = new RightFragment();
		ft.replace(R.id.left_frame, leftFragment);
		ft.replace(R.id.right_frame, rightFragment);

		centerFragment = new SampleListFragment();
		ft.replace(R.id.center_frame, centerFragment);
		ft.commit();

	}

	public void llronclick(View v) {
		switch (v.getId()) {
		case R.id.llr_energy_management:

			Intent intent = new Intent(this, DetailsActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}
	}

	public void showLeft() {
		mSlidingMenu.showLeftView();
	}

	public void showRight() {
		mSlidingMenu.showRightView();
	}

}
