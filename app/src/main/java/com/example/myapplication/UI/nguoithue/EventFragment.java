package com.example.myapplication.UI.nguoithue;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.LayoutInflater;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.View;

import com.example.myapplication.R;
import com.example.myapplication.adapter.nguoi_thue_adapter.EventAdapter;
import com.example.myapplication.dao.EventDAO;
import com.example.myapplication.itf.IClickitemEvent;

import java.util.ArrayList;
import java.util.List;

public class EventFragment extends Fragment {
    private RecyclerView rcvEvent;
    private View mView;
    private FragmentActivity mEventFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.activity_event_fragment, container, false);
        mEventFragment = getActivity();
        rcvEvent = mView.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mEventFragment);
        rcvEvent.setLayoutManager(linearLayoutManager);

        EventAdapter eventAdapter = new EventAdapter(getListEvent(), new IClickitemEvent() {
            @Override
            public void onClickitemEvent(EventDAO eventDAO) {
                onClickGoToDetail(eventDAO);
            }
        });
        rcvEvent.setAdapter(eventAdapter);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(mEventFragment,DividerItemDecoration.VERTICAL);
        rcvEvent.addItemDecoration(itemDecoration);
        return mView;
    }

    private List<EventDAO> getListEvent() {
        List<EventDAO> list = new ArrayList<>();
        list.add(new EventDAO("Giải bóng đá YBM CÚP ","Bắt đầu từ ngày 10-8->20-10","SDT LH: 0366151231",R.drawable.bongda1,"" +
                "I. MỤC ĐÍCH, YÊU CẦU \n" +
                "- Tạo sân chơi cho sinh viên,nâng cao phong trào bóng đá của trường,tạo điều kiện giao lưu giữa các lớp,các khối trong trường. \n" +
                "- Nâng cao tinh thần thể thao, rèn luyện sức khỏe của sinh viên, vì một tương lai đẩy giường bệnh lên dốc 1 mình!\n" +
                "- Nêu cao tinh thần đoàn kết, chấp hành đúng Điều lệ của giải, thi đấu nhiệt tình, trung thực. \n" +
                "II. ĐỐI TƯỢNG VÀ ĐIỀU KIỆN THAM DỰ GIẢI \n" +
                "1. Đối tượng \n" +
                "- Sinh viên các khối : K5,K6,K7 2. Đăng ký thi đấu \n" +
                "- Mỗi lớp được đăng ký thi đấu 01 đội tuyển, các cầu thủ của lớp nào sẽ phải đá đúng lớp đó.\n" +
                "- Các đội bóng khi tham gia thi đấu phải có đầy đủ trang phục thi đấu bóng đá cố định(có số áo, giày thi đấu đế mềm). Ban tổ chức căn cứ vào danh sách đăng ký của lớp để tính các danh hiệu có liên quan. \n" +
                "III.\uD83C\uDFEETHỜI GIAN VÀ ĐỊA ĐIỂM THI ĐẤU \n" +
                "- Thời gian đăng kí : Từ 24/12/2019 đến 31/12/2019 cho bạn Long lớp K7D, sđt 058 2289 285.\n" +
                "- Thời gian bốc thăm: 9h30 ngày 01/01/2020, địa điểm bốc thăm sẽ được ban tổ chức thông báo đến các đội đăng ký sau khi đăng ký thành công.\n" +
                "- Thời gian đá dự kiến: 13h30 Chủ Nhật hàng tuần từ ngày 05/01/2020 cho đến khi kết thúc giải (Dự kiến 1 tháng cho đội vào đến chung kết)\n" +
                "- Địa điểm tổ chức: Sân bóng Đại Học Y Hà Nội \n" +
                "IV. NỘI DUNG VÀ THỂ THỨC THI ĐẤU :\n" +
                "1. Nội dung: Bóng đá 07 người, đá sân cỏ nhân tạo. \n" +
                "2. Thể thức thi đấu, cách tính điểm, xếp hạng \n" +
                "- Ban tổ chức căn cứ vào số lượng các lớp đăng ký thi đấu để quyết định và công bố thể thức thi đấu trong cuộc họp chuyên môn với lãnh đội sau khi hoàn tất đăng ký. \n" +
                "- Thi đấu 2 hiệp, mỗi hiệp 30 phút (trừ thời gian bóng ngoài cuộc), nghỉ giữa 02 hiệp 10 phút. \n" +
                "- Cách tính điểm ở vòng bảng (nếu thi đấu vòng tròn): Thắng 3 điểm, hòa 1 điểm, thua 0 điểm, bỏ cuộc 0 điểm. \n" +
                "- Nếu 2 đội có điểm số bằng nhau thì các chỉ số được xét như sau: + Thành tích trận đối đầu. + Hiệu số bàn thắng/ bàn thua. + Số thẻ vàng (Đội nào có số thẻ vàng ít sẽ được ưu tiên). + Tổng số bàn thắng. + Nếu các chỉ số trên vẫn bằng nhau thì tiến hành bốc thăm. \n" +
                "\n" +
                "\n"));
        list.add(new EventDAO("Giải bóng đá doanh nhân trẻ","Bắt đầu từ ngày 5-8->15-10","SDT LH: 0366151231",R.drawable.bongda2,"\n" +
                "Tôn vinh các Doanh nghiệp trẻ Tiêu biểu có nhiều đóng góp sáng tạo, to lớn cho sự phát triển Tp.HCM nói riêng và xã hội nói chung.\n" +
                "Thông qua giải đấu và phương tiện truyền thông các Doanh Nghiệp có cơ hội quảng bá thương hiệu của mình trong và ngoài nước, đồng thời cũng là cầu nối hữu ích giữa Doanh Nghiệp và người tiêu dung.\n" +
                "Tạo mối quan hệ ngày càng gắn bó, tạo cơ hội giao lưu, học hỏi, trao đổi kinh nghiệm giữa các Doanh Nghiệp, thông qua các hoạt động thể dục thể thao một cách hiệu quả và thiết thực, từng bước đẩy mạnh phong trào rèn luyện thân thể trong các Doanh nghiệp.\n" +
                "A. ĐIỀU LỆ KỸ THUẬT:\n" +
                "1.Tên gọi của giải: GIẢI BÓNG ĐÁ CÁC DOANH NGHIỆP TRẺ TIÊU BIỂU KHU VỰC MIỀN NAM TRANH CÚP TRÍ TUỆ VIỆT – LẦN I \n" +
                "\n" +
                "1.1 Đơn vị sáng lập: Hội Doanh Nghiệp Trẻ Khu Vực Miền Nam\n" +
                "\n" +
                "1.2 Đơn vị điều hành giải: ĐH TDTT TP.HCM và CLB Bóng Đá Dương Minh Sài Gòn\n" +
                "\n" +
                "1.3 Đơn vị bảo trợ thông tin: Báo Thể Thao Sài Gòn.\n" +
                "\n" +
                "1.4 Đơn vị phụ trách chuyên môn và trọng tài: Bộ môn Bóng đá Trường ĐH TDTT\n" +
                "\n" +
                "Đối tượng tham dự:\n" +
                "\n" +
                "1  Là công dân Việt Nam, 18 tuổi trở lên: sinh trước ngày 01/01/1999. Một cầu thủ chỉ được đăng ký thi đấu cho một đội bóng duy nhất cho đến hết giải.\n" +
                "\n" +
                "2  Là quản lý, người lao động của Doanh nghiệp, được đội bóng đưa vào danh sách thi đấu và có xác nhận của Lãnh đạo Cty.\n" +
                "\n" +
                "3 Kiểm tra tư cách cầu thủ gồm: CMND bản gốc.\n" +
                "\n" +
                "4 Các cầu thủ phải đảm bảo sức khỏe để thi đấu. BTC sẽ không chịu trách nghiệm dưới bất kỳ hình thức nào về vấn đề sức khỏe của nghững thành viên tham dự giải đấu.\n" +
                "\n" +
                "5 Những cầu thủ đã đăng ký thi đấu tại giải Futsal Eximbank A, giải Futsal Vô địch thành phố Hồ Chí Minh, Futsal các đội mạnh thành phố Hồ Chí Minh mở rộng – Cúp LS, giải Futsal Vô địch Quốc Gia, Futsal Toàn quốc năm 2015, năm 2016 năm 2017 không được đăng ký thi đấu.\n" +
                "\n" +
                "6 Những cầu thủ đã đăng ký thi đấu tại giải bóng đá, Hạng Ba, Hạng Nhì, Hạng Nhất Quốc gia, Cúp Quốc gia, Vô địch Quốc gia, năm 2015, năm 2016, năm 2017 không được đăng ký thi đấu."));
        list.add(new EventDAO("Giải bóng đá INTERBANK WINTER CUP ","Bắt đầu từ ngày 8-10->20-10 ->","SDT LH: 0366151231",R.drawable.bongda3,"" +
                "I. MỤC ĐÍCH, YÊU CẦU \n" +
                "- Tạo sân chơi cho sinh viên,nâng cao phong trào bóng đá của trường,tạo điều kiện giao lưu giữa các lớp,các khối trong trường. \n" +
                "- Nâng cao tinh thần thể thao, rèn luyện sức khỏe của sinh viên, vì một tương lai đẩy giường bệnh lên dốc 1 mình!\n" +
                "- Nêu cao tinh thần đoàn kết, chấp hành đúng Điều lệ của giải, thi đấu nhiệt tình, trung thực. \n" +
                "II. ĐỐI TƯỢNG VÀ ĐIỀU KIỆN THAM DỰ GIẢI \n" +
                "1. Đối tượng \n" +
                "- Sinh viên các khối : K5,K6,K7 2. Đăng ký thi đấu \n" +
                "- Mỗi lớp được đăng ký thi đấu 01 đội tuyển, các cầu thủ của lớp nào sẽ phải đá đúng lớp đó.\n" +
                "- Các đội bóng khi tham gia thi đấu phải có đầy đủ trang phục thi đấu bóng đá cố định(có số áo, giày thi đấu đế mềm). Ban tổ chức căn cứ vào danh sách đăng ký của lớp để tính các danh hiệu có liên quan. \n" +
                "III.\uD83C\uDFEETHỜI GIAN VÀ ĐỊA ĐIỂM THI ĐẤU \n" +
                "- Thời gian đăng kí : Từ 24/12/2019 đến 31/12/2019 cho bạn Long lớp K7D, sđt 058 2289 285.\n" +
                "- Thời gian bốc thăm: 9h30 ngày 01/01/2020, địa điểm bốc thăm sẽ được ban tổ chức thông báo đến các đội đăng ký sau khi đăng ký thành công.\n" +
                "- Thời gian đá dự kiến: 13h30 Chủ Nhật hàng tuần từ ngày 05/01/2020 cho đến khi kết thúc giải (Dự kiến 1 tháng cho đội vào đến chung kết)\n" +
                "- Địa điểm tổ chức: Sân bóng Đại Học Y Hà Nội \n" +
                "IV. NỘI DUNG VÀ THỂ THỨC THI ĐẤU :\n" +
                "1. Nội dung: Bóng đá 07 người, đá sân cỏ nhân tạo. \n" +
                "2. Thể thức thi đấu, cách tính điểm, xếp hạng \n" +
                "- Ban tổ chức căn cứ vào số lượng các lớp đăng ký thi đấu để quyết định và công bố thể thức thi đấu trong cuộc họp chuyên môn với lãnh đội sau khi hoàn tất đăng ký. \n" +
                "- Thi đấu 2 hiệp, mỗi hiệp 30 phút (trừ thời gian bóng ngoài cuộc), nghỉ giữa 02 hiệp 10 phút. \n" +
                "- Cách tính điểm ở vòng bảng (nếu thi đấu vòng tròn): Thắng 3 điểm, hòa 1 điểm, thua 0 điểm, bỏ cuộc 0 điểm. \n" +
                "- Nếu 2 đội có điểm số bằng nhau thì các chỉ số được xét như sau: + Thành tích trận đối đầu. + Hiệu số bàn thắng/ bàn thua. + Số thẻ vàng (Đội nào có số thẻ vàng ít sẽ được ưu tiên). + Tổng số bàn thắng. + Nếu các chỉ số trên vẫn bằng nhau thì tiến hành bốc thăm. \n" +
                "\n" +
                "\n"));
        list.add(new EventDAO("Giải bóng đá MINI NAM NỮ ","Bắt đầu từ ngày 8-10->20-10 ->","SDT LH: 0366151231",R.drawable.bongda4,"" +
                "ĐIỀU LỆ GIẢI BÓNG ĐÁ MINI NAM-NỮ\n" +
                "HỘI THAO VĂN HÓA CHÀO MỪNG 18 NĂM THÀNH LẬP\n" +
                "CÔNG VIÊN PHẦN MỀM QUANG TRUNG\n" +
                "I. ĐIỀU LỆ CHUNG THI ĐẤU\n" +
                "1. Điều lệ kỹ thuật:\n" +
                " - Mỗi đội bóng đăng ký danh sách tối đa 15 vận động viên, danh sách vận động\n" +
                "viên thi đấu phải được đóng dấu xác nhận vào ảnh và danh sách cầu thủ và được Lãnh đạo\n" +
                "đơn vị có đội bóng tham gia giải duyệt. Số áo và tên vận động viên phải cố định suốt cả\n" +
                "giải đấu như trong danh sách đăng ký ban đầu và không được thay đổi cho vận động viên\n" +
                "khác.\n" +
                "- Vận động viên bắt buộc phải mang theo thẻ nhân viên; thẻ bảo hiểm y tế hoặc\n" +
                "CMND cá nhân để BTC kiểm tra và làm thủ tục trước khi vào sân thi đấu\n" +
                "- Mọi trường hợp thay đổi về vận động viên của các đội bóng phải thực hiện trước\n" +
                "thời gian BTC bốc thăm lịch thi đấu.\n" +
                " - Thay người: Khi VĐV trong sân bước ra khỏi sân thay người, thì vận động viên\n" +
                "khác ở ngoài đường piste mới được vào sân.\n" +
                "- VĐV phải mang giày ba ta (giày vải), giày chuyên dùng cho sân bóng đá mini cỏ\n" +
                "nhân tạo khi thi đấu (không được mang giày đinh, đi chân trần thi đấu).\n" +
                "- Chỉ có Trưởng đoàn hay huấn luyện viên của đội mới được quyền khiếu nại với\n" +
                "đại diện BTC trên sân.\n" +
                " 2. Trang phục thi đấu và bóng thi đấu:\n" +
                " - Các đội phải đăng ký màu đồng phục thi đấu với BTC. Áo quần thi đấu do mỗi\n" +
                "đội tự trang bị theo tiêu chuẩn: đồng phục (màu áo của 02 đội không được trùng nhau trừ\n" +
                "màu áo của thủ môn). Số áo của các vận động viên phải được in trên áo, có số áo khác nhau\n" +
                "và mặc cố định số áo đó trong suốt cả giải. Trong một trận đấu, nếu hai đội bóng có màu\n" +
                "áo gần giống nhau thì trọng tài cho tiến hành bốc thăm để chọn đội khoác áo Piste..\n" +
                "II. THỜI GIAN TIẾN HÀNH GIẢI\n" +
                " - Họp triển khai Điều lệ giải và bốc thăm các bảng thi đấu vòng loại: lúc 14 giờ\n" +
                "ngày 25/3/2019.\n" +
                " - Khai mạc: lúc 17h00 ngày 29/3/2019 & dự kiến bế mạc trao giải lúc 19h30\n" +
                "ngày 10/5/2019.\n"));
        list.add(new EventDAO("Giải bóng đá MINI 7 người ","Bắt đầu từ ngày 8-10->20-10 ->","SDT LH: 0366151231",R.drawable.bongda5,"I. Mục đích và ý nghĩa\n" +
                " 1. Mục đích\n" +
                "- Tạo sân chơi cho các đội bóng đang hoạt động trong địa bàn Tp HCM\n" +
                "và các khu vực lân cận giao l°u học hỏi , đoàn kết, rèn luyện sức khỏe\n" +
                "II. Thể thức thi đấu , thời gian giai đấu\n" +
                "1) Thể thức:\n" +
                "- Mỗi đội bóng được đăng ký tối đa 18 người bao gồm 15 cầu thủ (1 HLV, 1\n" +
                "TRƯỞNG ĐOÀN , 1 SN SÓC VIÊN)\n" +
                "- Giải đấu gồm 4 đội, chia làm 2 cặp đấu A1 vs A2 và B1 vs B2, thi đấu knock-out( loại\n" +
                "trực tiếp). để chọn hai đội thắng của mỗi cặp đấu vào ch¡i trận chung kết còn hai đội thua\n" +
                "của mỗi bảng sẽ thi đấu tranh hạng 3 4\n" +
                "- â tất cả trận đấu nếu 2 đội hòa nhau trong 2 hiệp thi đấu chính thức, sẽ vào đá penaty\n" +
                " 2) Thßi gian :\n" +
                "Các đßi bóng tham dự gửi danh sách cầu thÿ , kèm hình Ánh cÿa thành viên đßi\n" +
                "bóng vß cho BTC trước ngày 12/09/2022\n" +
                " -Khai m¿c , bốc x\u0004m vào lúc 17h45 ngày 16/09/2022\n" +
                "1. Trận đấu thứ nhất 18H00 ngày 16/09/2022: X\u0004m A1 VS A2\n" +
                "2. Trận đấu thứ hai 19H00 ngày 16/09/2022: X\u0004m B1 VS B2\n" +
                "3. Trận đấu tranh hạng 3 : 18H00 ngày 17/09/2022\n" +
                "4. Trận chung kết, trao giải : 19H00 ngày 17/09/2022"));
        list.add(new EventDAO("Giải bóng đá Tân sinh viên HTT","Bắt đầu từ ngày 8-10->20-10 ->","SDT LH: 0366151231",R.drawable.bongda6,""));
        return list;
    }
    private void onClickGoToDetail(EventDAO eventDAO){
        Intent intent = new Intent(getContext(), DetailEvent.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_event",eventDAO);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}