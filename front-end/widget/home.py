from PyQt5.QtWidgets import QApplication, QMessageBox
from PyQt5 import uic
import requests

class Home:
    def __init__(self):
        self.ui = uic.loadUi('../ui/home.ui')
        self.ui.pushButton.clicked.connect(self.handleCalc)
        self.ui.requestButton.clicked.connect(self.post_req)

    def handleCalc(self):
        print('helloworld')

    def req(self):
        url = 'http://127.0.0.1:4523/m1/5005042-0-default/api/case/detail'
        res = requests.get(url)
        self.ui.reqLabel.setText(res.text)

    def post_req(self):

        name = self.ui.nameEdit.text()
        tp = self.ui.typeEdit.text()
        description = self.ui.descriptionEdit.toPlainText()
        print(name+tp+description)

        # url = 'http://127.0.0.1:4523/m1/5005042-0-default/api/case/create'
        # res = requests.post(url, data={'name':name,'type':type,'description':description}, headers={'Content-Type': 'application/json'})
        # print(res.text)




app = QApplication([])
stats = Home()
stats.ui.show()
app.exec_()
