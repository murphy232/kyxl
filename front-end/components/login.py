from PyQt5 import QtCore, QtWidgets
from PyQt5.QtCore import *
from PyQt5.QtWidgets import QMainWindow, QApplication
from ui import ui_login
import main

from qt_material import apply_stylesheet

class LoginWindow(QMainWindow, ui_login.Ui_login):
    def __init__(self):
        super().__init__()
        self.setupUi(self)
        self.pushButton_2.clicked.connect(self.login)  # Connect the login button to the login method

    def login(self):

        main.MyApp().show()
        self.close()

if __name__ == "__main__":
    import sys

    QtCore.QCoreApplication.setAttribute(Qt.AA_EnableHighDpiScaling)  # 适应windows缩放

    app = QApplication(sys.argv)
    # setup stylesheet
    # apply_stylesheet(app, theme='dark_teal.xml')
    app.setStyleSheet(open('../custom/styleSheet.qss', encoding='utf-8').read())
    window = LoginWindow()
    window.show()
    sys.exit(app.exec_())
