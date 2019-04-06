package bo;

import java.util.ArrayList;

import bean.BaoCaoBean;
import dao.BaoCaoDao;

public class BaoCaoBo {
	BaoCaoDao baocaodao = new BaoCaoDao();
	public ArrayList<BaoCaoBean> bc;
	public ArrayList<BaoCaoBean> getBaoCao() throws Exception {
		bc = baocaodao.getBaoCao();
		return bc;
	}
}
