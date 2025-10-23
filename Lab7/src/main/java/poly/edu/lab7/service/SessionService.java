package poly.edu.lab7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;

@Service

public class SessionService {
    @Autowired
    HttpSession session;

    // Lưu giá trị vào session
    public void set(String name, Object value) {
        session.setAttribute(name, value);
    }

    // Lấy giá trị từ session
    @SuppressWarnings("unchecked")
    public <T> T get(String name, T defaultValue) {
        T value = (T) session.getAttribute(name);
        return value != null ? value : defaultValue;
    }

    // Xóa session
    public void remove(String name) {
        session.removeAttribute(name);
    }
}
